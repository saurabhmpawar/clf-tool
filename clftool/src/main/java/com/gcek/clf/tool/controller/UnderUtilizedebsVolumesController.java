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
 * @author saurabh pawar	
 *
 */
@WebServlet(urlPatterns = "/undrUtilizedEbs.do")
public class UnderUtilizedebsVolumesController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(UnderUtilizedebsVolumesController.class);
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOGGER.info("----inside UnderUtilizedebsVolumesController doget----");
		request.getRequestDispatcher("/WEB-INF/views/underUtilizedEbs.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.info("----inside UnderUtilizedebsVolumesController do post ----");

	}

}
