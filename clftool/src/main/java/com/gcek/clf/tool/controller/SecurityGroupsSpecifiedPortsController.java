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

@WebServlet(urlPatterns = "/Security_Groups_Specified_Ports.do")
public class SecurityGroupsSpecifiedPortsController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(SecurityGroupsSpecifiedPortsController.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.info("----inside SecurityGroupsSpecifiedPorts----");

		AwsEC2ServiceOps ec2ServiceOps = new AwsEc2ServiceOpsImpl();

		try {
			request.setAttribute("securityGroupList",	ec2ServiceOps.getSecurityGroups());
		} catch (BusinessException e) {
			LOGGER.error("error at get security groups", e);
		}

		request.getRequestDispatcher("/WEB-INF/views/Security_Groups_Specified_Ports.jsp").forward(request, response);

	}
}
