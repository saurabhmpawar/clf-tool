package com.gcek.clf.tool.model;

import com.amazonaws.services.s3.model.Bucket;

public class MyBucket extends Bucket {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String identifier;

	public String access;

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	@Override
	public String toString() {
		return "MyBucket [identifier=" + identifier + ", access=" + access + "]";
	}
	
	
	
}
