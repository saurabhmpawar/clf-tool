package com.gcek.clf.tool.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet(urlPatterns = "/smtp-setting.do")
public class SmtpSettingController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(SmtpSettingController.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOGGER.info("----inside SmtpSettingController----");
		request.getRequestDispatcher("/WEB-INF/views/smtp-setting.jsp").forward(request, response);
	}


	
	
}
