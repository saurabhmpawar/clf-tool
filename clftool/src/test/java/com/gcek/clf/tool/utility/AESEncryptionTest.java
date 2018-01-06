package com.gcek.clf.tool.utility;

import org.junit.Assert;
import org.junit.Test;

public class AESEncryptionTest {

	@Test
	public void testEncrypt() {

		Assert.assertEquals("1k6vsJ18kdLpCLIH77Wyww==", AESEncryption.encrypt("saurabh-pawar"));

	}

	@Test
	public void testDecrypt() {

		Assert.assertEquals("saurabh-pawar", AESEncryption.decrypt("1k6vsJ18kdLpCLIH77Wyww=="));

	}

}
