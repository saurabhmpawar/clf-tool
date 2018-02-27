package com.gcek.clf.tool.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.gcek.clf.tool.aws.AwsEC2ServiceOps;
import com.gcek.clf.tool.aws.AwsS3ServiceOps;
import com.gcek.clf.tool.aws.impl.AwsEc2ServiceOpsImpl;
import com.gcek.clf.tool.aws.impl.AwsS3ServiceOpsImpl;
import com.gcek.clf.tool.utility.BusinessException;

/**
 * 
 * @author saurabh pawar	
 *
 */
@WebServlet(urlPatterns = "/UnutiliaedIpAddresses.do")
public class UnutilizedElpAddressesController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(UnutilizedElpAddressesController.class);
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOGGER.info("----inside UnutiliaedIpAddresses doget----");
		
		
		AwsEC2ServiceOps ec2 = new AwsEc2ServiceOpsImpl();

		try {
			request.setAttribute("ipList", ec2.getPublicIp());
			LOGGER.info(ec2.getPublicIp().toString());
		} catch (BusinessException e) {
			LOGGER.error("seeror at ip", e);
			request.setAttribute("errorMessage", e.getCause());
		
		}
		request.getRequestDispatcher("/WEB-INF/views/UnutiliaedIpAddresses.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.info("----inside UnutiliaedIpAddresses do post ----");

	}

}
