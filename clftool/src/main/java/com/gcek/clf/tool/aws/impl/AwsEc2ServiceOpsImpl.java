package com.gcek.clf.tool.aws.impl;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.Address;
import com.amazonaws.services.ec2.model.DescribeSecurityGroupsResult;
import com.amazonaws.services.ec2.model.SecurityGroup;
import com.amazonaws.services.ec2.model.Volume;
import com.gcek.clf.tool.aws.AwsEC2ServiceOps;
import com.gcek.clf.tool.model.MySecurityGroup;
import com.gcek.clf.tool.utility.AWSClientGenerator;
import com.gcek.clf.tool.utility.BusinessException;

public class AwsEc2ServiceOpsImpl implements AwsEC2ServiceOps {

	@Override
	public List<MySecurityGroup> getSecurityGroups() throws BusinessException {
		List<MySecurityGroup> mySecurityGroups = new ArrayList<>();

		// call ec2 client
		AmazonEC2 ec2 = AWSClientGenerator.getAWSEc2Client();
		
		DescribeSecurityGroupsResult  result=	ec2.describeSecurityGroups();
		List<SecurityGroup>  securityGroups =result.getSecurityGroups();
		for (SecurityGroup securityGroup :securityGroups)
		{
			MySecurityGroup mySecurityGroup = new MySecurityGroup();
			//TODO main logic
			mySecurityGroup.setColor("RED");
			mySecurityGroup.setDescription(securityGroup.getDescription());
			mySecurityGroup.setGroupId(securityGroup.getGroupId());
			mySecurityGroup.setGroupName(securityGroup.getGroupName());
			mySecurityGroup.setIpPermissions(securityGroup.getIpPermissions());
			
			
			
			mySecurityGroups.add(mySecurityGroup);
		}
		
		return mySecurityGroups;
	}

	@Override
	public List<Address> getPublicIp() throws BusinessException {
		AmazonEC2 ec2 = AWSClientGenerator.getAWSEc2Client();		
		return ec2.describeAddresses().getAddresses();
	}

	@Override
	public List<Volume> getEbsInfo() throws BusinessException {
		
		AmazonEC2 ec2 = AWSClientGenerator.getAWSEc2Client();			
		return ec2.describeVolumes().getVolumes();
	}

	
}
	