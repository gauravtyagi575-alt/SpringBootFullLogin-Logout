package com.app.util;

import java.security.SecureRandom;

public class RandomPasswordUtil {

	private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890@#$%&*";
	private static final SecureRandom RND = new SecureRandom();
	
	public static String generate(int length) {
		StringBuilder sb = new StringBuilder(length);
		for(int i = 0; i< length; i++) {
		sb.append(CHARS.charAt(RND.nextInt(CHARS.length())));
	}
		return sb.toString();
}
}
