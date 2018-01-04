package com.gcek.clf.tool.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.gcek.clf.tool.dao.UserManagementDao;
import com.gcek.clf.tool.dao.impl.UserManagementDaoImpl;
import com.gcek.clf.tool.utility.BusinessException;

@WebServlet(urlPatterns = "/list-users.do")

public class ListUsersController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(ListUsersController.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOGGER.info("----inside ListUsersController----");
		/*
		 * Properties properties = new Properties();
		 * properties.load(getServletContext().getResourceAsStream(
		 * "/resources/config.properties")); Enumeration<?> enumeration =
		 * properties.propertyNames(); while (enumeration.hasMoreElements()) {
		 * String key = (String) enumeration.nextElement(); LOGGER.info("Key: "
		 * + key + "   Value: " + properties.getProperty(key));
		 * 
		 * }
		 */

		UserManagementDao userMgt = new UserManagementDaoImpl();
		try {
			request.setAttribute("userList", userMgt.getAllUsers());
		} catch (BusinessException e) {

			LOGGER.error("Error while listing users", e);
		}

		request.getRequestDispatcher("/WEB-INF/views/list-users.jsp").forward(request, response);
	}
}
