package com.kennycode.hyperengagesmvc.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kennycode.hyperengagesmvc.models.User;

public class ValidateUser {

	
	private static Pattern pattern;
	private static Matcher matcher;
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	/**
	 * This validate will just return true when everything is okay and false if got any problem.
	 * 
	 * Fields to validate:
	 * > username, email, password (before
	 * 
	 * username, email, password is not empty
	 * username should be larger or equal 4
	 * password should be larger or equal 8
	 * 
	 * @param user
	 * @return true if all of fields is okay
	 */
	public static boolean createAccount(User user) {
		if(user == null)
			return false;
		if(user.getUsername().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty())
			return false;
		if(user.getUsername().length() < 4 || user.getPassword().length() < 8)
			return false;
		
		// get pattern and compile
		pattern = Pattern.compile(EMAIL_PATTERN);
		// check the email 
		matcher = pattern.matcher(user.getEmail());
		// the email is the last thing to validate in that part, if return true, everything okay.
		return matcher.matches();

	}
	/**
	 * This validate will return String message with errors.
	 * @param user
	 * @return
	 */
	public static String createAccountGetErrors(User user) {
		// i will finish that soon.
		return null;
	}
	
}
