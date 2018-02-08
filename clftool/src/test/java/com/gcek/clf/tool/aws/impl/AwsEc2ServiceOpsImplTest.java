package com.gcek.clf.tool.aws.impl;

import java.util.List;

import org.junit.Test;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.DescribeSecurityGroupsResult;
import com.amazonaws.services.ec2.model.IpPermission;
import com.amazonaws.services.ec2.model.SecurityGroup;
import com.gcek.clf.tool.aws.AwsEC2ServiceOps;
import com.gcek.clf.tool.utility.AWSClientGenerator;
import com.gcek.clf.tool.utility.BusinessException;

public class AwsEc2ServiceOpsImplTest {
	@Test
	public void testEc2() {
		System.out.println("shree");

		AmazonEC2 ec2 = AWSClientGenerator.getAWSEc2Client();
		DescribeSecurityGroupsResult result = ec2.describeSecurityGroups();

		List<SecurityGroup> seuritygroups = result.getSecurityGroups();

		for (SecurityGroup securityGroup : seuritygroups) {

			System.out.println(securityGroup.getGroupName());
			List<IpPermission> per = securityGroup.getIpPermissions();

			for (IpPermission i : per) {
				System.out.println("==================");
				System.out.println(i.getIpProtocol());
				System.out.println(i.getIpv4Ranges());
				System.out.println(i.getFromPort());
				System.out.println(i.getToPort());

			}
			System.out.println(securityGroup.getIpPermissions().toString());
		}
	}

	@Test
	public void testMysecurityGroup() {
		AwsEC2ServiceOps s = new AwsEc2ServiceOpsImpl();
		try {
			System.out.println(s.getSecurityGroups().toString());

		} catch (BusinessException e) {

			e.printStackTrace();
		}
	}
}
