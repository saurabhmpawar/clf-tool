package com.gcek.clf.tool.model;

import java.util.Date;

public class JobDetails {

	private String jobName;
	private String jobGroup;
	private Date nextFireTime;

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public Date getNextFireTime() {
		return nextFireTime;
	}

	public void setNextFireTime(Date nextFireTime) {
		this.nextFireTime = nextFireTime;
	}

	@Override
	public String toString() {
		return "JobDetails [jobName=" + jobName + ", jobGroup=" + jobGroup + ", nextFireTime=" + nextFireTime + "]";
	}

}
