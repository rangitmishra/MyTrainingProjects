package com.nagarro.fileupload.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import com.nagarro.fileupload.data.Image;
import com.nagarro.fileupload.data.User;
import com.nagarro.fileupload.service.HibernateUtil;

public class ImageManagementDao {
	private final String UPLOAD_DIRECTORY = "C:/uploads";

	private ImageManagementDao() {
	}

	private static ImageManagementDao imageDao = new ImageManagementDao();

	public static ImageManagementDao getInstance() {
		return imageDao;

	}

	public void deleteImage(int iiD) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "DELETE FROM Image " + "WHERE imageId = :id";

		Query query = session.createQuery(hql);

		query.setParameter("id", iiD);

		int result = query.executeUpdate();

		session.getTransaction().commit();
		session.close();
	}

	public void editImage(String newName, int iiD) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "UPDATE Image set imageName = :name " + "WHERE imageId = :id";
		Query query = session.createQuery(hql);
		query.setParameter("name", newName);
		query.setParameter("id", iiD);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);

		session.getTransaction().commit();
		session.close();
	}

	public void uploadImage(List<FileItem> multiparts, int uid) throws Exception {

		String name = null;
		for (FileItem item : multiparts) {

			if (!item.isFormField()) {

				name = new File(item.getName()).getName();

				item.write(new File(UPLOAD_DIRECTORY + File.separator + name));

			}
		}

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		File file = new File(UPLOAD_DIRECTORY + File.separator + name);
		byte[] bFile = new byte[(int) file.length()];

		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			// convert file into array of bytes
			fileInputStream.read(bFile);
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Image avatar = new Image();
		avatar.setSize((int) file.length());
		avatar.setOriginalImage(Hibernate.getLobCreator(session).createBlob(bFile));
		avatar.setImageName(name);

		Query q = session.createQuery("from User AS U where U.userId = :userIdCode");
		q.setParameter("userIdCode", uid);

		User res = (User) q.list().get(0);
		avatar.setUser(res);

		session.save(avatar);

		session.getTransaction().commit();
		session.close();

	}

	public void changePassword(String newName, String password) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "UPDATE User set password = :pwd " + "WHERE userName = :name";
		Query query = session.createQuery(hql);
		query.setParameter("name", newName);
		query.setParameter("pwd", password);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
		session.close();

	}

	public void registerUser(String name, String pwd) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		User user = new User();
		user.setUserName(name);
		user.setPassword(pwd);

		session.save(user);

		session.getTransaction().commit();
		session.close();
	}

}
