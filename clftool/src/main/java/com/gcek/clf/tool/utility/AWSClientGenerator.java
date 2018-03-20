package com.gcek.clf.tool.utility;

import org.apache.log4j.Logger;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagement;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagementClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.gcek.clf.tool.dao.AWSCrientialsDao;
import com.gcek.clf.tool.dao.impl.AWScridentialsDaoImpl;
import com.gcek.clf.tool.model.AWScridentials;
import com.gcek.clf.tool.model.Constants;

public class AWSClientGenerator {

	public static final Logger LOGGER = Logger.getLogger(AWSClientGenerator.class);

	/**
	 * get credentials form db
	 * 
	 * @return
	 * @throws BusinessException
	 */
	private static BasicAWSCredentials getAWSCridentialsFromDB() throws BusinessException {

		AWSCrientialsDao dao = new AWScridentialsDaoImpl();
		AWScridentials awScridentials;
		awScridentials = dao.getCridentials(Constants.AWS_KEY_ID);
		String accesKey = AESEncryption.decrypt(awScridentials.getAccessKey());
		String secretKey = AESEncryption.decrypt(awScridentials.getSecretKey());
		return new BasicAWSCredentials(accesKey, secretKey);
	}

	/**
	 * Aws s3 client
	 * 
	 * @return
	 */
	public static AmazonS3 getAWSS3clinet() {
		try {
			BasicAWSCredentials awsCreds = getAWSCridentialsFromDB();
			return AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();

		} catch (BusinessException e) {
			LOGGER.error("Error while getting s3 client ", e);
		}
		return null;
	}

	/**
	 * ec2 client
	 * 
	 * @return
	 */
	public static AmazonEC2 getAWSEc2Client() {
		try {
			BasicAWSCredentials awsCreds = getAWSCridentialsFromDB();
			return AmazonEC2ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCreds))
					.build();

		} catch (BusinessException e) {
			LOGGER.error("Error while getting ec2 client ", e);
		}
		return null;
	}

	/**
	 * IAM client
	 * 
	 * @return
	 */
	public static AmazonIdentityManagement getAwsIAMClient() {
		try {

			BasicAWSCredentials awsCreds = getAWSCridentialsFromDB();

			return AmazonIdentityManagementClientBuilder.standard()
					.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
		} catch (BusinessException e) {
			LOGGER.error("Error while getting ec2 client ", e);
		}
		return null;

	}
}
