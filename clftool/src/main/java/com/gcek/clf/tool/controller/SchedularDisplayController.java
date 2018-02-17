package com.gcek.clf.tool.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.quartz.SchedulerException;

import com.gcek.clf.tool.utility.jobs.ListJobs;

/**
 * 
 * @author saurabh pawar
 *
 */
@WebServlet(urlPatterns = "/SchedularDisplay.do")
public class SchedularDisplayController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(SchedularDisplayController.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOGGER.info("----inside SchedularDisplay doget----");

		ListJobs j = new ListJobs();
		try {

			request.setAttribute("jobList", j.ListAllJobs());

		} catch (SchedulerException e) {
			request.setAttribute("errorMessage", e.getCause());

			LOGGER.error("error", e);
		}

		request.getRequestDispatcher("/WEB-INF/views/SchedularDisplay.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.info("----inside SchedularDisplay do post ----");

	}

}
