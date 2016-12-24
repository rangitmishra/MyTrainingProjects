package com.nagarro.fileupload.service;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.nagarro.fileupload.util.ImageManagementDao;

/**
 * Servlet implementation class ImageUpload
 */
@WebServlet("/ImageUpload")
public class ImageUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private final String UPLOAD_DIRECTORY = "C:/uploads";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		if (ServletFileUpload.isMultipartContent(request)) {

			try {

				@SuppressWarnings("unchecked")
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				int uid=(int) request.getSession().getAttribute("userId");
				ImageManagementDao.getInstance().uploadImage(multiparts, uid);
		        request.getRequestDispatcher("./imageUpload.jsp").forward(request,response);


			} catch (Exception ex) {

				request.setAttribute("message", "File Upload Failed due to " + ex);
				
				ex.printStackTrace();
				request.getRequestDispatcher("/result.jsp").forward(request, response);
			}

		} else {

			request.setAttribute("message", "Sorry this Servlet only handles file upload request");
			request.getRequestDispatcher("/result.jsp").forward(request, response);

		}

	}

}
