package com.gcek.clf.tool.dao;

import com.gcek.clf.tool.model.SmtpSetting;
import com.gcek.clf.tool.utility.BusinessException;

public interface SmtpSettingDao {

	
	public void createSmtpSetting(SmtpSetting smtpSetting)throws BusinessException ;
	
	
 }
