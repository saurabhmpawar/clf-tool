package com.gcek.clf.tool.utility;

public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String messaString, Throwable t) {
		super(messaString, t);
	}
}
