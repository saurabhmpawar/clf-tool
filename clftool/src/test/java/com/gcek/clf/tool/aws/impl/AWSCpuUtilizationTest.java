package com.gcek.clf.tool.aws.impl;

import java.awt.Dimension;
import java.io.IOException;
import java.util.Date;

import org.junit.Test;

import com.amazonaws.auth.BasicAWSCredentials;

public class AWSCpuUtilizationTest {

	@Test
	public static void main(String[] args) throws IOException {

		final String awsAccessKey = "AKIAJPYSTVAYTYAEUJKQ";
		final String awsSecretKey = "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";
		final String instanceId = "i-007c0baf4ab1504ff";

		final AmazonCloudWatchClient client = client(awsAccessKey, awsSecretKey);
		final GetMetricStatisticsRequest request = request(instanceId);
		final GetMetricStatisticsResult result = result(client, request);
		toStdOut(result, instanceId);
	}

	private static AmazonCloudWatchClient client(final String awsAccessKey, final String awsSecretKey) {
		return new AmazonCloudWatchClient(new BasicAWSCredentials(awsAccessKey, awsSecretKey));
	}

	private static GetMetricStatisticsRequest request(final String instanceId) {
		final long twentyFourHrs = 1000 * 60 * 60 * 24;
		final int oneHour = 60 * 60;
		return new GetMetricStatisticsRequest().withStartTime(new Date(new Date().getTime() - twentyFourHrs))
				.withNamespace("AWS/EC2").withPeriod(oneHour)
				.withDimensions(new Dimension().withName("InstanceId").withValue(instanceId))
				.withMetricName("CPUUtilization").withStatistics("Average", "Maximum").withEndTime(new Date());
	}

	private static GetMetricStatisticsResult result(final AmazonCloudWatchClient client,
			final GetMetricStatisticsRequest request) {
		return client.getMetricStatistics(request);
	}

	private static void toStdOut(final GetMetricStatisticsResult result, final String instanceId) {
		System.out.println(result); // outputs empty result: {Label:
									// CPUUtilization,Datapoints: []}
		for (final Datapoint dataPoint : result.getDatapoints()) {
			System.out.printf("%s instance's average CPU utilization : %s%n", instanceId, dataPoint.getAverage());
			System.out.printf("%s instance's max CPU utilization : %s%n", instanceId, dataPoint.getMaximum());
		}
	}

}
