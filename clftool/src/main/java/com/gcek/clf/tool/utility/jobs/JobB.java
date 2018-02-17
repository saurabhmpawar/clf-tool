package com.gcek.clf.tool.utility.jobs;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
/**
 * 
 * @author Pavan.Pawar
 *
 *	This is every day job run at 10 a.m
 */
public class JobB implements Job {
	static final Logger LOGGER = Logger.getLogger(JobB.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		LOGGER.info("Job sending home page report is runing at " + new Date());

			try {
			//	EmailReportCreatorService r = new EmailReportCreatorServiceImpl();
			//	String body = r.getHomepagageReport();
	//			EmailSendingService s = new EmailSendingServiceSESImpl();
			
		//	s.sendMail("", "", "", body);
		} catch (Exception e) {

			LOGGER.error("Error while sending email form jobB ", e);
		}
		LOGGER.info("Job sending home page report is completed at " + new Date());
	}

}