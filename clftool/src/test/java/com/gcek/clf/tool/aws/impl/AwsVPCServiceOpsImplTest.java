package com.gcek.clf.tool.aws.impl;

import java.util.List;
import org.junit.Test;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.DescribeVpcsResult;
import com.amazonaws.services.ec2.model.Vpc;
import com.gcek.clf.tool.utility.AWSClientGenerator;

public class AwsVPCServiceOpsImplTest {

	@Test
	public void testVpc() {

		AmazonEC2 ec2 = AWSClientGenerator.getAWSEc2Client();
		DescribeVpcsResult result = ec2.describeVpcs();
		
		List<Vpc> vpcs = result.getVpcs();

		for (Vpc vpcs1 : vpcs) {
			
			System.out.println(vpcs1.getCidrBlock());
			System.out.println(vpcs1.getTags());

		}

	}
}
