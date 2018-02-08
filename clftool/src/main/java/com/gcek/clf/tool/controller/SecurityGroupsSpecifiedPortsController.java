package com.gcek.clf.tool.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet(urlPatterns = "/Security_Groups_Specified_Ports.do")
public class SecurityGroupsSpecifiedPortsController extends HttpServlet {
	public static final Logger LOGGER = Logger.getLogger(SecurityGroupsSpecifiedPortsController.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.info("----inside SecurityGroupsSpecifiedPorts----");
		request.getRequestDispatcher("/WEB-INF/views/Security_Groups_Specified_Ports.jsp").forward(request, response);

	}
}
