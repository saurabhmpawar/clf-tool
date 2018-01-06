package com.gcek.clf.tool.utility;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

/**
 * 
 * 
 * @author saurabh pawar
 */
public class AESEncryption {
	static final Logger logger = Logger.getLogger(AESEncryption.class);

	private static final String encryptionKey = "FB99387F382617F6";
	private static final String characterEncoding = "UTF-8";
	private static final String cipherTransformation = "AES/CBC/PKCS5PADDING";
	private static final String aesEncryptionAlgorithem = "AES";

	/**
	 * Method for Encrypt Plain String Data
	 * 
	 * @param plainText
	 * @return encryptedText
	 */
	public static String encrypt(String plainText) {
		String encryptedText = "";
		try {
			Cipher cipher = Cipher.getInstance(cipherTransformation);
			byte[] key = encryptionKey.getBytes(characterEncoding);
			SecretKeySpec secretKey = new SecretKeySpec(key, aesEncryptionAlgorithem);
			IvParameterSpec ivparameterspec = new IvParameterSpec(key);
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivparameterspec);
			byte[] cipherText = cipher.doFinal(plainText.getBytes("UTF8"));
			Base64.Encoder encoder = Base64.getEncoder();
			encryptedText = encoder.encodeToString(cipherText);

		} catch (Exception E) {
			logger.error("Encrypt Exception : " + E.getMessage(), E);
		}
		return encryptedText;
	}

	/**
	 * Method For Get encryptedText and Decrypted provided String
	 * 
	 * @param encryptedText
	 * @return decryptedText
	 */
	public static String decrypt(String encryptedText) {
		String decryptedText = "";
		try {
			Cipher cipher = Cipher.getInstance(cipherTransformation);
			byte[] key = encryptionKey.getBytes(characterEncoding);
			SecretKeySpec secretKey = new SecretKeySpec(key, aesEncryptionAlgorithem);
			IvParameterSpec ivparameterspec = new IvParameterSpec(key);
			cipher.init(Cipher.DECRYPT_MODE, secretKey, ivparameterspec);
			Base64.Decoder decoder = Base64.getDecoder();
			byte[] cipherText = decoder.decode(encryptedText.getBytes("UTF8"));
			decryptedText = new String(cipher.doFinal(cipherText), "UTF-8");

		} catch (Exception E) {
			logger.error("decrypt Exception : " + E.getMessage(), E);
		}
		return decryptedText;
	}

}
