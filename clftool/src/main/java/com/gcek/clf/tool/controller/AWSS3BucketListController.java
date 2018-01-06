package com.gcek.clf.tool.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.gcek.clf.tool.aws.AwsS3ServiceOps;
import com.gcek.clf.tool.aws.impl.AwsS3ServiceOpsImpl;
import com.gcek.clf.tool.utility.BusinessException;

@WebServlet(urlPatterns = "/aws-s3-buck-list.do")
public class AWSS3BucketListController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -912133939936619105L;
	public static final Logger LOGGER = Logger.getLogger(AWSS3BucketListController.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.info("----inside AWSS3BucketListController----");
		AwsS3ServiceOps s3 = new AwsS3ServiceOpsImpl();

		try {
			request.setAttribute("bucketList", s3.listAccountBuckets());
			//LOGGER.info( s3.listAccountBuckets().toString());
		} catch (BusinessException e) {
			LOGGER.error("seeror at s3", e);
			request.setAttribute("errorMessage", e.getCause());
		
		}
		request.getRequestDispatcher("/WEB-INF/views/s3BucketList.jsp").forward(request, response);

	}

}
