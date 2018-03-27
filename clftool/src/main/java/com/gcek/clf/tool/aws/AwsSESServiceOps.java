package com.gcek.clf.tool.aws;

import com.gcek.clf.tool.utility.BusinessException;

public interface AwsSESServiceOps {

	public void sendMail(String from, String to, String subject , String body) throws BusinessException;
}
