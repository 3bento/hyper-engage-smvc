package com.kennycode.hyperengagesmvc.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PasswordEncryptTest {

	@Test
	public void encryptPasswordWithSHA() {

		String password = "abcdefg";
		String hexHash = PasswordEncrypt.encryptSHA(password);
		System.out.println(password + " -> " + hexHash);
		assertEquals(hexHash, PasswordEncrypt.encryptSHA(password));
	}

	@Test
	public void checkEncryptedPasswordWithSHA() {
		String hashPassword = "7d1a54127b222502f5b79b5fb0803061152a44f92b37e23c6527baf665d4da9a";
		String stringPassword = "abcdefg";
		System.out.println(hashPassword + " -> " + PasswordEncrypt.encryptSHA(stringPassword));
		assertEquals(hashPassword, PasswordEncrypt.encryptSHA(stringPassword));
	}
}
