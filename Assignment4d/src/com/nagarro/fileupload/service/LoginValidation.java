package com.nagarro.fileupload.service;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.annotation.MultipartConfig;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;
import com.nagarro.fileupload.data.User;

/**
 * Servlet implementation class LoginValidation
 */
@MultipartConfig(maxFileSize = 1699999)
// @WebServlet("/LoginValidation")
public class LoginValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		response.setContentType("text/html");
		String name = request.getParameter("uname");
		String pwd = request.getParameter("pwd");

		try {
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
			SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			// Session session =
			// HibernateUtil.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(User.class);

			cr.add(Restrictions.eq("userName", name));
			cr.add(Restrictions.eq("password", pwd));

			@SuppressWarnings("unchecked")
			List<User> user = cr.list();
			if (user.size() > 0) {

				request.getSession().setAttribute("userId", user.get(0).getUserId());

				request.setAttribute("images", user.get(0).getImages());
				request.getRequestDispatcher("./imageUpload.jsp").forward(request, response);

			} else {

				if (request.getSession().getAttribute("userId") == null && name.length() == 0) {
					response.sendRedirect("fail.jsp");
				} else {
					out.println("This is not a valid user");
				}

			}
			// session.getTransaction().commit();
			transaction.commit();
			session.close();

		} catch (HibernateException e) {
			System.out.println("Panga yaha hi");
			e.printStackTrace();
		}

	}

}
