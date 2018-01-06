package com.gcek.clf.tool.utility;

import org.junit.Assert;
import org.junit.Test;

public class XXXXConverterUtilTest {

	@Test
	public void testXXX() {
		System.out.println(XXXXConverterUtil.generateXXXX("1222"));
		Assert.assertEquals("1222", XXXXConverterUtil.generateXXXX("1222"));

	}

	@Test
	public void testXXX2() {
		System.out.println(XXXXConverterUtil.generateXXXX("V3zvxKLbQSxWdupheZSGFcYgYY7C31BB8jq7FtYo"));
		Assert.assertEquals("XXXXXXXXXXXXXXXw3d3", XXXXConverterUtil.generateXXXX("asasdasd33333ddw3d3"));
	}
}
