package com.gcek.clf.tool.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.gcek.clf.tool.dao.UserManagementDao;
import com.gcek.clf.tool.dao.impl.UserManagementDaoImpl;
import com.gcek.clf.tool.model.User;
import com.gcek.clf.tool.utility.BusinessException;

@WebServlet(urlPatterns = "/add-user.do")

public class AddUserController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(AddUserController.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOGGER.info("----inside AddUserController----");
		request.getRequestDispatcher("/WEB-INF/views/add-user.jsp").forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String emailID = request.getParameter("email");
		String firstName = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String role = request.getParameter("role");
		String password = request.getParameter("password");

		LOGGER.info("EmailiD: " + emailID + ", firstname " + firstName + ", lastname:" + lastname + ", role:" + role
				+ ",  password:" + password);
		User myuser = new User(emailID, firstName, lastname, password, role);
		myuser.setCreatedOn(new Date());
		myuser.setModifiedBy("sourbh");

		UserManagementDao usrMgt = new UserManagementDaoImpl();
		try {
			usrMgt.addUser(myuser);
			response.sendRedirect("list-users.do");
		} catch (BusinessException e)

		{

			LOGGER.error("error at adduser:", e);
			request.setAttribute("errorMessage", e.getCause());
			request.getRequestDispatcher("/WEB-INF/views/add-user.jsp").forward(request, response);

		}

	}
}
