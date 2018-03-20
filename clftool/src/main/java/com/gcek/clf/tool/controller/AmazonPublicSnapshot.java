package com.gcek.clf.tool.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.gcek.clf.tool.aws.AwsEC2ServiceOps;
import com.gcek.clf.tool.aws.impl.AwsEc2ServiceOpsImpl;
import com.gcek.clf.tool.utility.BusinessException;

@WebServlet(urlPatterns = "/Amazon_ublic_snapshot.do")
public class AmazonPublicSnapshot extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(AmazonPublicSnapshot.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AwsEC2ServiceOps ec2 = new AwsEc2ServiceOpsImpl();

		try {
			request.setAttribute("snapshots", ec2.getAllSnapshot());
			LOGGER.info(ec2.getEbsInfo());
		} catch (BusinessException e) {
			LOGGER.error("seeror at snapshot", e);
			request.setAttribute("errorMessage", e.getCause());
		
		}
		
		LOGGER.info("----inside AmazonPublicSnapshot----");
		request.getRequestDispatcher("/WEB-INF/views/Amazon_ublic_snapshot.jsp").forward(request, response);

	}
}
