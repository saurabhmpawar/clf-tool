package com.gcek.clf.tool.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.gcek.clf.tool.aws.AwsSESServiceOps;
import com.gcek.clf.tool.aws.impl.AwsSESServiceOpsImpl;
import com.gcek.clf.tool.utility.BusinessException;

@WebServlet(urlPatterns = "/sendmail.do")
public class SendMailController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(SendMailController.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.info("----inside SendMailController----");

		request.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(request, response);

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String toemail = request.getParameter("toemail");
		String sub = request.getParameter("subject");

		LOGGER.info("to " + toemail + ", subject " + sub );

		try {

			AwsSESServiceOps ops = new AwsSESServiceOpsImpl();
			String from = "saurabhpawar1396@gmail.com";
		
			String subject = "This is sampl report of CFL tool";
			String body = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"> <html lang=\"en\"> <head> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> <title></title> <style type=\"text/css\"> </style> </head> <body style=\"margin: 0; padding: 0; background-color: #F2F2F2;\"> <center> <h1>CLF Tool</h1> <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#F2F2F2\"> <tr> <td align=\"center\" valign=\"top\"> <h2>Amazon Web services Cloud</h2> </td> </tr> </table> <table width=\"100%\" border=\"0\" cellpadding=\"10\" cellspacing=\"0\" bgcolor=\"#F2F2F2\"> <tr> <td align=\"center\" valign=\"top\">AWS Instance Details <table width=\"100%\" border=\"1\" cellpadding=\"5\" cellspacing=\"0\" bgcolor=\"#F2F2F2\"> <tr> <td>Total Instances</td> <td>:Aws_total_instance_count</td> </tr> <tr> <td>Running Instances</td> <td>:Aws_running_instance_count</td> </tr> <tr> <td>Stopped Instances</td> <td>:Aws_stopped_instance_count</td> </tr> </table> </td> <td align=\"center\" valign=\"top\">AWS Available EBS Volumes <table width=\"100%\" border=\"1\" cellpadding=\"5\" cellspacing=\"0\" bgcolor=\"#F2F2F2\"> <tr> <td>Total unattached EBS Volumes Count</td> <td>:Aws_avalable_EBS_volume_count</td> </tr> <tr> <td>Total unattached EBS Volumes Size</td> <td>:Aws_avalable_EBS_volume_size</td> </tr> <tr> <td bgcolor=\"#ffff4d\">Projected monthly cost saving (if resources run for 30 days)</td> <td bgcolor=\"#ffff4d\">:Aws_EBS_projected_cost_saving</td> </tr> </table> </td> </tr> </table> <h3> please check detailed report at http://localhost:82/clftool </h3> </center> <p> Note: This report is generated at <b> :reportTime </b></p> </body> </html>";
			ops.sendMail(from, toemail, subject, body);
			request.setAttribute("successMessage", "email sent ");
			request.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(request, response);

		} catch (BusinessException e) {
			LOGGER.error("error at send email:", e);
			request.setAttribute("errorMessage", e.getCause());
			request.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(request, response);

		}

	}

}
