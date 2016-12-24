/*
 * Class name: Delete File
 * Version info:
 * Copyright notice:
 * Author info: ranjeetmishra
 * Creation date: 02September2016
 * Last updated by: ranjeetmishra
 * Last updated date: 02September2016
 * Description: Deletes the image on clicking of delete button
 */
package com.nagarro.fileupload.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.fileupload.util.ImageManagementDao;

/**
 * 
 * @author ranjeetmishra
 * @version 1.8
 * @since 2016-09-03
 */
@WebServlet("/DeleteFile")
public class DeleteFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
/*Constructor of Delete File() */
	public DeleteFile() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("get of delete");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
/**
 * @param request This keep the id of image which is to be deleted
 * @param response
 * @return void
 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("delete of post");
		int iiD = Integer.parseInt(request.getParameter("imgId"));                                                          //iiD takes the value of image id from request object
		System.out.println("one");
		ImageManagementDao.getInstance().deleteImage(iiD);                                                              //calling deleteImage function which deletes image
		System.out.println("two");
		request.getRequestDispatcher("./imageUpload.jsp").forward(request, response);              //goes to imageUpload page  after performing deletion
		doGet(request, response);

	}

}