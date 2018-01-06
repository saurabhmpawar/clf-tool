package com.gcek.clf.tool.aws.impl;

import java.util.List;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.gcek.clf.tool.aws.AwsS3ServiceOps;
import com.gcek.clf.tool.utility.AWSClientGenerator;
import com.gcek.clf.tool.utility.BusinessException;

public class AwsS3ServiceOpsImpl implements AwsS3ServiceOps {

	@Override
	public List<Bucket> listAccountBuckets() throws BusinessException {
		AmazonS3 s3 = AWSClientGenerator.getAWSS3clinet();
		return s3.listBuckets();
	}

}
