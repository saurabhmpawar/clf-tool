package com.gcek.clf.tool.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * 
 * @author saurabh.Pawar
 *
 */
@WebServlet(urlPatterns = "/login.do")
public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3213511969183034733L;

	public static final Logger LOGGER = Logger.getLogger(LoginController.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOGGER.info("----inside Login----");
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.info("----inside Login do post ----");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		LOGGER.debug("----user tried to login----" + name);

		// TODO make database connection and try to validate with database
		if (name.equalsIgnoreCase("saurabhpawar1396@gmial.com") && password.equals("admin@123")) {

			request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);

		} else {
			request.setAttribute("errorMessage", "Wroing user name or password");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}

	}

}
