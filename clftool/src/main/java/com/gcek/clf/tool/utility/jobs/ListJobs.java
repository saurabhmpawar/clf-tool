package com.gcek.clf.tool.utility.jobs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/*
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.triggers.SimpleTriggerImpl;

import com.gcek.clf.tool.model.JobDetails;

public class ListJobs {

	public List<JobDetails> ListAllJobs() throws SchedulerException {

		List<JobDetails> jobList = new ArrayList<>();
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		// Creating Job and link to our Job class
		JobDetailImpl jobDetail = new JobDetailImpl();
		jobDetail.setName("First Job");
		jobDetail.setJobClass(JobA.class);

		// Creating schedule time with trigger
		SimpleTriggerImpl simpleTrigger = new SimpleTriggerImpl();
		simpleTrigger.setStartTime(new Date(System.currentTimeMillis() + 1000));
		simpleTrigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
		simpleTrigger.setRepeatInterval(2000);
		simpleTrigger.setName("FirstTrigger");

		// Start scheduler
		// scheduler.start();
		// scheduler.scheduleJob(jobDetail, simpleTrigger);

		for (String groupName : scheduler.getJobGroupNames()) {
			for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {
				JobDetails jobdetail = new JobDetails();
				String jobName = jobKey.getName();
				String jobGroup = jobKey.getGroup();
				List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
				Date nextFireTime = triggers.get(0).getNextFireTime();
				jobdetail.setJobGroup(jobGroup);
				jobdetail.setJobName(jobName);
				jobdetail.setNextFireTime(nextFireTime);
				jobList.add(jobdetail);
				System.out.println("[jobName] : " + jobName + " [groupName] : " + jobGroup + " - " + nextFireTime);
			}

		}

		return jobList;
	}

}*/
