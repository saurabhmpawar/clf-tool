package com.gcek.clf.tool.utility;

public class XXXXConverterUtil {

	public static String generateXXXX(String xxxx) {

		if (xxxx != null && xxxx.length() > 4) {
			String firstHalf = new String(new char[xxxx.length() - 4]).replace('\0', 'X');
			String seconHalf = xxxx.substring(xxxx.length() - 4, xxxx.length());

			return firstHalf + seconHalf;
		} else {
			return xxxx;
		}
	}
}
