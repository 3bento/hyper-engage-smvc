package com.kennycode.hyperengagesmvc.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncrypt {
	/**
	 * Receive password convert encrypt to bytes with SHA 256 after that Convert the bytes to hexdecimal.
	 * @param password
	 * @return
	 */
	public static String encryptSHA(String password) {
		String hexString = "";
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
			hexString = convertBytesToHex(encodedhash);
			
		} catch (NoSuchAlgorithmException e) {
			e.getStackTrace();
		}
		return hexString;
	}

	/**
	 * Receive password and hash to check if them is equal.
	 * @param password - normal string
	 * @param hash - password is encrypted
	 * @return
	 */
	public static boolean checkEncrypted(String password, String hash) {
		if(hash.equals(encryptSHA(password))) {
			return true;
		}else {
			return false;
		}
	}
	
	private static String convertBytesToHex(byte[] hash) {
		StringBuffer hexString = new StringBuffer();
		for(int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if(hex.length() == 1) hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}
}
