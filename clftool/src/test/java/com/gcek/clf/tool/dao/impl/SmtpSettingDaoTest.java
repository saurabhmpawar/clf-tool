package com.gcek.clf.tool.dao.impl;

import org.junit.Test;

import com.gcek.clf.tool.dao.SmtpSettingDao;
import com.gcek.clf.tool.model.SmtpSetting;
import com.gcek.clf.tool.utility.BusinessException;

public class SmtpSettingDaoTest {

	@Test
	public void addSmtpTest() {
	
		System.out.println("inside SMTP test");
		
		SmtpSetting s = new SmtpSetting("adc", "ava", "adsca", "avdsa", "avdss", "ds");
		SmtpSettingDao dao = new SmtpSettingDaoImpl();
		
		try {
			dao.createSmtpSetting(s);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
