package com.gcek.clf.tool.aws.impl;

import java.util.List;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.Vpc;
import com.gcek.clf.tool.aws.AwsVPCServiceOps;
import com.gcek.clf.tool.utility.AWSClientGenerator;
import com.gcek.clf.tool.utility.BusinessException;

public class AwsVPCServiceOpsImpl implements AwsVPCServiceOps {

	@Override
	public List<Vpc> getVpcs() throws BusinessException {
		// TODO Auto-generated method stub
		AmazonEC2 ec2 = AWSClientGenerator.getAWSEc2Client();			
		return ec2.describeVpcs().getVpcs();
		
	}





	
}
