package com.gcek.clf.tool.aws.impl;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.Grant;
import com.gcek.clf.tool.aws.AwsS3ServiceOps;
import com.gcek.clf.tool.model.MyBucket;
import com.gcek.clf.tool.utility.AWSClientGenerator;
import com.gcek.clf.tool.utility.BusinessException;

public class AwsS3ServiceOpsImpl implements AwsS3ServiceOps {

	@Override
	public List<MyBucket> listAccountBuckets() throws BusinessException {
		AmazonS3 s3 = AWSClientGenerator.getAWSS3clinet();

		List<MyBucket> mybucketList = new ArrayList<>();

		List<Bucket> s3Buckets = s3.listBuckets();

		for (Bucket b : s3Buckets) {
			MyBucket bucket = new MyBucket();

			try {
				AccessControlList acl = s3.getBucketAcl(b.getName());
				List<Grant> grants = acl.getGrantsAsList();
				String identifier = "NA";
				
				for (Grant grant : grants) {
					identifier += " " + grant.getGrantee().getIdentifier() + " : " + grant.getPermission().toString();
					System.out.format("  %s: %s\n", grant.getGrantee().getIdentifier(),
							grant.getPermission().toString());
				}

				bucket.setIdentifier(identifier);
			} catch (Exception e) {

			}
			bucket.setName(b.getName());
			bucket.setCreationDate(b.getCreationDate());

			mybucketList.add(bucket);
		}

		
		
		return mybucketList;
	}

}
