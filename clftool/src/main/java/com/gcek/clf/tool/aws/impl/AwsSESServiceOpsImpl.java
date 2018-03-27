package com.gcek.clf.tool.aws.impl;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.gcek.clf.tool.utility.BusinessException;

public class AwsSESServiceOpsImpl implements com.gcek.clf.tool.aws.AwsSESServiceOps {

	@Override
	public void sendMail(String from, String to, String subject, String body) throws BusinessException {
		//String CONFIGSET = "ConfigSet";
		String TEXTBODY = "This email was sent through CLF Tool  " + "using the AWS SDK for Java.";

		try {

			AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
					// Replace US_WEST_2 with the AWS Region you're using for
					// Amazon SES.
					.withRegion(Regions.US_EAST_1).build();
			SendEmailRequest request = new SendEmailRequest()
					.withDestination(
							new Destination()
									.withToAddresses(
											to))
					.withMessage(new Message()
							.withBody(new Body().withHtml(new Content().withCharset("UTF-8").withData(body))
									.withText(new Content().withCharset("UTF-8").withData(TEXTBODY)))
							.withSubject(new Content().withCharset("UTF-8").withData(subject)))
					.withSource(from);
			// Comment or remove the next line if you are not using a
			// configuration set
			// .withConfigurationSetName(CONFIGSET);
			client.sendEmail(request);
			System.out.println("Email sent!");
		} catch (Exception ex) {
			System.out.println("The email was not sent. Error message: " + ex.getMessage());
		}

	}

}
