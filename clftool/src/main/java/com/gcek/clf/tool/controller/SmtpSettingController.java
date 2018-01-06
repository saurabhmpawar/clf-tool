package com.gcek.clf.tool.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.gcek.clf.tool.dao.SmtpSettingDao;
import com.gcek.clf.tool.dao.impl.SmtpSettingDaoImpl;
import com.gcek.clf.tool.model.SmtpSetting;
import com.gcek.clf.tool.model.User;
import com.gcek.clf.tool.utility.BusinessException;

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

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String smtpUrl = request.getParameter("SmtpUrl");
		String smtpName = request.getParameter("SmtpName");
		String smtpPassword = request.getParameter("SmtpPassword");
		String smtpPort = request.getParameter("SmtpPort");
		String smtpSsl = request.getParameter("SmtpSsl");
		String smtpEmail = request.getParameter("SmtpEmail");

		LOGGER.info("Smtpurl " + smtpUrl + ", SmtpName " + smtpName + ", SmtpPasseword:" + smtpPassword + ",SmtpPort:"
				+ smtpPort + ",  SmtpSsl:" + smtpSsl + ", SmtpEmail:" + smtpEmail);
		SmtpSetting smtpsetting = new SmtpSetting(smtpUrl, smtpName, smtpPassword, smtpEmail, smtpPort, smtpSsl);
		SmtpSettingDao dao = new SmtpSettingDaoImpl();

		try {
			dao.createSmtpSetting(smtpsetting);

			request.setAttribute("successMessage", "recoard saved ");
			request.getRequestDispatcher("/WEB-INF/views/smtp-setting.jsp").forward(request, response);

		} catch (BusinessException e) {
			LOGGER.error("error at SMTP setting:", e);
			request.setAttribute("errorMessage", e.getCause());
			request.getRequestDispatcher("/WEB-INF/views/smtp-setting.jsp").forward(request, response);

		}

	}

}
