package com.gcek.clf.tool.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
@WebServlet(urlPatterns = "/Amazon_ublic_snapshot.do")
public class Amazon_ublic_snapshot extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(Amazon_ublic_snapshot.class);
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.info("----inside IamUserController----");
		request.getRequestDispatcher("/WEB-INF/views/Amazon_ublic_snapshot.jsp").forward(request, response);

	}
}
