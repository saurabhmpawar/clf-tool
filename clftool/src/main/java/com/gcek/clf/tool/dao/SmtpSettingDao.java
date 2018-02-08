package com.gcek.clf.tool.dao;

import java.util.List;

import com.gcek.clf.tool.model.SmtpSetting;
import com.gcek.clf.tool.utility.BusinessException;

public interface SmtpSettingDao {

	public void createSmtpSetting(SmtpSetting smtpSetting) throws BusinessException;

	public List<SmtpSetting> getAllSmtp() throws BusinessException;

	/**
	 * validate user with database
	 * 
	 * 
	 */

}
