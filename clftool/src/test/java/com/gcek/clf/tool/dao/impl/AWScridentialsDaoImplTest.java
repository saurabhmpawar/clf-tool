package com.gcek.clf.tool.dao.impl;

import org.junit.Test;

import com.gcek.clf.tool.dao.AWSCrientialsDao;
import com.gcek.clf.tool.model.AWScridentials;
import com.gcek.clf.tool.utility.BusinessException;

public class AWScridentialsDaoImplTest {

	@Test
	public void addCridential() {
		AWSCrientialsDao dao = new AWScridentialsDaoImpl();
		AWScridentials awScridentials = new AWScridentials("sssss", "ssss");
		try {
			dao.addCridentails(awScridentials);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
