package com.gcek.clf.tool.aws.impl;

import java.awt.Dimension;
import java.io.IOException;
import java.util.Date;

import org.junit.Test;

import com.amazonaws.auth.BasicAWSCredentials;

public class AWSCpuUtilizationTest {

	@Test
	public static void main(String[] args) throws IOException {

		final String awsAccessKey = "";
		final String awsSecretKey = "";
		final String instanceId = "";

	//	final AmazonCloudWatchClient client = client(awsAccessKey, awsSecretKey);
//		final GetMetricStatisticsRequest request = request(instanceId);
	//	final GetMetricStatisticsResult result = result(client, request);
		//toStdOut(result, instanceId);
	//}

//	private static AmazonCloudWatchClient client(final String awsAccessKey, final String awsSecretKey) {/
//		return new AmazonCloudWatchClient(new BasicAWSCredentials(awsAccessKey, awsSecretKey));
	//}

	/*private static GetMetricStatisticsRequest request(final String instanceId) {
		final long twentyFourHrs = 1000 * 60 * 60 * 24;
		final int oneHour = 60 * 60;
		return new GetMetricStatisticsRequest().withStartTime(new Date(new Date().getTime() - twentyFourHrs))
				.withNamespace("AWS/EC2").withPeriod(oneHour)
				.withDimensions(new Dimension().withName("InstanceId").withValue(instanceId))
				.withMetricName("CPUUtilization").withStatistics("Average", "Maximum").withEndTime(new Date());
	}

*/
	}
}
