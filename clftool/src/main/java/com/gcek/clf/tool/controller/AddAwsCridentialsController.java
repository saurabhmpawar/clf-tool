package com.gcek.clf.tool.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.gcek.clf.tool.dao.AWSCrientialsDao;
import com.gcek.clf.tool.dao.impl.AWScridentialsDaoImpl;
import com.gcek.clf.tool.model.AWScridentials;
import com.gcek.clf.tool.utility.BusinessException;

@WebServlet(urlPatterns = "/aws-setting.do")
public class AddAwsCridentialsController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(AddAwsCridentialsController.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.info("----inside AddAwsCridentialsController----");
		request.getRequestDispatcher("/WEB-INF/views/awsCrientials-setting.jsp").forward(request, response);

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String accessKey = request.getParameter("accessKey");
		String secretKey = request.getParameter("secertKey");

		LOGGER.info("accessKey " + accessKey + ", secertKey " + secretKey);
		AWSCrientialsDao dao = new AWScridentialsDaoImpl();

		AWScridentials awScridentials = new AWScridentials(accessKey, secretKey);

		try {
			
			dao.addCridentails(awScridentials);

			request.setAttribute("successMessage", "recoard saved ");
			request.getRequestDispatcher("/WEB-INF/views/awsCrientials-setting.jsp").forward(request, response);

		} catch (BusinessException e) {
			LOGGER.error("error at SMTP setting:", e);
			request.setAttribute("errorMessage", e.getCause());
			request.getRequestDispatcher("/WEB-INF/views/awsCrientials-setting.jsp").forward(request, response);

		}

	}

}
