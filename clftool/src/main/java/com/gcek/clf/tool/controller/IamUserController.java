package com.gcek.clf.tool.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.amazonaws.services.identitymanagement.AmazonIdentityManagement;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagementClientBuilder;
import com.amazonaws.services.identitymanagement.model.ListUsersResult;
import com.amazonaws.services.identitymanagement.model.User;
import com.gcek.clf.tool.aws.AwsIAMServiceOps;
import com.gcek.clf.tool.aws.impl.AwsIamServiceOpsImapl;
import com.gcek.clf.tool.utility.BusinessException;

@WebServlet(urlPatterns = "/IAM_use.do")
public class IamUserController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(IamUserController.class);
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.info("----inside IamUserController----");
		AwsIAMServiceOps iam = new AwsIamServiceOpsImapl();
		
		try {
			request.setAttribute("users",iam.getAllIamUSerInMyAccount());
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			LOGGER.error("error at iam", e);
			request.setAttribute("errorMessage", e.getCause());

		}
		
		request.getRequestDispatcher("/WEB-INF/views/IAM_use.jsp").forward(request, response);

	}

}
