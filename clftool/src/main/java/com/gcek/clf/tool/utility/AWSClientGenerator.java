package com.gcek.clf.tool.utility;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.gcek.clf.tool.dao.AWSCrientialsDao;
import com.gcek.clf.tool.dao.impl.AWScridentialsDaoImpl;
import com.gcek.clf.tool.model.AWScridentials;
import com.gcek.clf.tool.model.Constants;

public class AWSClientGenerator {

	public static AmazonS3 getAWSS3clinet() {
		try {
			AWSCrientialsDao dao = new AWScridentialsDaoImpl();

			AWScridentials awScridentials;

			awScridentials = dao.getCridentials(Constants.AWS_KEY_ID);

			BasicAWSCredentials awsCreds = new BasicAWSCredentials(AESEncryption.decrypt(awScridentials.getAccessKey()),
					AESEncryption.decrypt(awScridentials.getSecretKey()));
			return AmazonS3ClientBuilder.standard()
					.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
			
		} catch (BusinessException e) {

		}
		return null;
	}
}
