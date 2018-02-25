package com.gcek.clf.tool.aws;

import java.util.List;

import com.amazonaws.services.identitymanagement.model.User;
import com.gcek.clf.tool.utility.BusinessException;

/**
 * 
 *@author saurabh pawar
 * */
public interface AwsIAMServiceOps {

	
	List<User> getAllIamUSerInMyAccount()throws BusinessException;
	
}
