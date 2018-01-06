package com.gcek.clf.tool.model;

public class AWScridentials {

	private String accessKey;
	private String secretKey;
	private String accessKeyXXX;
	private String secretKeyXXX;

	public AWScridentials() {
	}

	public AWScridentials(String accessKey, String secretKey) {
		super();
		this.accessKey = accessKey;
		this.secretKey = secretKey;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getAccessKeyXXX() {
		return accessKeyXXX;
	}

	public void setAccessKeyXXX(String accessKeyXXX) {
		this.accessKeyXXX = accessKeyXXX;
	}

	public String getSecretKeyXXX() {
		return secretKeyXXX;
	}

	public void setSecretKeyXXX(String secretKeyXXX) {
		this.secretKeyXXX = secretKeyXXX;
	}

	
}
