package com.gcek.clf.tool.model;

public class SmtpSetting {

	private String smtpUrl;
	private String smtpName;
	private String smtpPassword;
	private String smtpSenderEmail;
	private String smtpPort;
	private String smtpSsl;

	public SmtpSetting(String smtpUrl, String smtpName, String smtpPassword, String smtpSenderEmail, String smtpPort,
			String smtpSsl) {
		super();
		this.smtpUrl = smtpUrl;
		this.smtpName = smtpName;
		this.smtpPassword = smtpPassword;
		this.smtpSenderEmail = smtpSenderEmail;
		this.smtpPort = smtpPort;
		this.smtpSsl = smtpSsl;
	}

	public SmtpSetting() {
	}

	public String getSmtpUrl() {
		return smtpUrl;
	}

	public void setSmtpUrl(String smtpUrl) {
		this.smtpUrl = smtpUrl;
	}

	public String getSmtpName() {
		return smtpName;
	}

	public void setSmtpName(String smtpName) {
		this.smtpName = smtpName;
	}

	public String getSmtpPassword() {
		return smtpPassword;
	}

	public void setSmtpPassword(String smtpPassword) {
		this.smtpPassword = smtpPassword;
	}

	public String getSmtpSenderEmail() {
		return smtpSenderEmail;
	}

	public void setSmtpSenderEmail(String smtpSenderEmail) {
		this.smtpSenderEmail = smtpSenderEmail;
	}

	public String getSmtpPort() {
		return smtpPort;
	}

	public void setSmtpPort(String smtpPort) {
		this.smtpPort = smtpPort;
	}

	public String getSmtpSsl() {
		return smtpSsl;
	}

	public void setSmtpSsl(String smtpSsl) {
		this.smtpSsl = smtpSsl;
	}

}
