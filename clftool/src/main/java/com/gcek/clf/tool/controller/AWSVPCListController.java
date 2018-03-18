package com.gcek.clf.tool.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.gcek.clf.tool.aws.AwsVPCServiceOps;
import com.gcek.clf.tool.aws.impl.AwsVPCServiceOpsImpl;
import com.gcek.clf.tool.utility.BusinessException;

@WebServlet(urlPatterns = "/aws-vpc-list.do")
public class AWSVPCListController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -912133939936619105L;
	public static final Logger LOGGER = Logger.getLogger(AWSVPCListController.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.info("----inside AWSVPCListController----");
		AwsVPCServiceOps vp1 = new AwsVPCServiceOpsImpl();

		try {
			request.setAttribute("vpcList", vp1.getVpcs());
			// LOGGER.info( s3.listAccountBuckets().toString());
		} catch (BusinessException e) {
			LOGGER.error("eeror at vpc", e);
			request.setAttribute("errorMessage", e.getCause());

		}
		request.getRequestDispatcher("/WEB-INF/views/list-vpc.jsp").forward(request, response);

	}
}
