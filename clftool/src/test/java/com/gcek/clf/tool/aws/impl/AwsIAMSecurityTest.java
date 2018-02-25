package com.gcek.clf.tool.aws.impl;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.gcek.clf.tool.aws.AwsIAMServiceOps;

public class AwsIAMSecurityTest {

	
	@Test
	public void testListIAM() {

		try {
		
			AwsIAMServiceOps iam = new AwsIamServiceOpsImapl();
		System.out.println(	iam.getAllIamUSerInMyAccount().toString());
			Assert.assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	
	
}
