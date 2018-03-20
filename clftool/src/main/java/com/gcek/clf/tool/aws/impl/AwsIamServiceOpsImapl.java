package com.gcek.clf.tool.aws.impl;

import java.util.List;

import com.amazonaws.services.identitymanagement.AmazonIdentityManagement;
import com.amazonaws.services.identitymanagement.model.ListUsersResult;
import com.amazonaws.services.identitymanagement.model.User;
import com.gcek.clf.tool.aws.AwsIAMServiceOps;
import com.gcek.clf.tool.utility.AWSClientGenerator;
import com.gcek.clf.tool.utility.BusinessException;

public class AwsIamServiceOpsImapl implements AwsIAMServiceOps {

	@Override
	public List<User> getAllIamUSerInMyAccount() throws BusinessException {

		AmazonIdentityManagement i = AWSClientGenerator.getAwsIAMClient();
		ListUsersResult result = i.listUsers();
		return result.getUsers();

	}

}
