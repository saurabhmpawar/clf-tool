package com.gcek.clf.tool.utility;

import java.net.URI;
import java.sql.Date;

/**
 * 
 * @author
 *
 */
public class CommonUtility {
	private CommonUtility() {
	}

	public static Date sqlDateConversion(java.util.Date utilDate) {
		return new java.sql.Date(utilDate.getTime());
	}

	public static String getStortfilneNameFromUrl(URI uri) {
		String[] segments = uri.getPath().split("/");
		return segments[segments.length - 1];

	}
}