package com.gcek.clf.tool.aws.impl;

import org.junit.Ignore;
import org.junit.Test;

import com.gcek.clf.tool.aws.AwsS3ServiceOps;
import com.gcek.clf.tool.utility.BusinessException;

public class AwsS3ServiceOpsImplTest {
	@Ignore
	@Test
	public void listBucketsTEst() {
		AwsS3ServiceOps s3 = new AwsS3ServiceOpsImpl();
		
		try {
			System.out.println(s3.listAccountBuckets().toString());
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}