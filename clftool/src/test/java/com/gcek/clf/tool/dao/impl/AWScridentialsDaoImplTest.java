package com.gcek.clf.tool.dao.impl;

import org.junit.Test;

import com.gcek.clf.tool.dao.AWSCrientialsDao;
import com.gcek.clf.tool.model.AWScridentials;
import com.gcek.clf.tool.model.Constants;
import com.gcek.clf.tool.utility.AESEncryption;
import com.gcek.clf.tool.utility.BusinessException;

public class AWScridentialsDaoImplTest {

	@Test
	public void addCridentialTest() {
		AWSCrientialsDao dao = new AWScridentialsDaoImpl();
		AWScridentials awScridentials = new AWScridentials("sssss", "ssss");
		try {
			dao.addCridentails(awScridentials);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void getCridentialtest() {
		AWSCrientialsDao dao = new AWScridentialsDaoImpl();
		try {
			AWScridentials awScridentials = dao.getCridentials(Constants.AWS_KEY_ID);
			System.out.println(AESEncryption.decrypt(awScridentials.getAccessKey()) + " "
					+ AESEncryption.decrypt(awScridentials.getSecretKey()));
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
