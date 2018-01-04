package com.gcek.clf.tool.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


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
}
