package com.javaapp.demo.util;

import java.util.regex.Pattern;

public class ValidationUtil {

	private static final String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	private static final String phoneRegex = "^[6-9]\\d{9}$";
	private static final String pinRegex = "^[0-9]{6}$";

	public static boolean isValidEmail(String email) {
		if (email == null || email.isEmpty()) {
			return false;
		}
		Pattern p = Pattern.compile(emailRegex);
		return p.matcher(email).matches();
	}

	public static boolean isValidPhoneNumner(String phoneNumber) {
		if (phoneNumber == null || phoneNumber.isEmpty()) {
			return false;
		}
		Pattern p = Pattern.compile(phoneRegex);
		return p.matcher(phoneNumber).matches();
	}

	public static boolean isValidPIN(String pin) {
		if (pin == null || pin.isEmpty()) {
			return false;
		}
		Pattern p = Pattern.compile(pinRegex);
		return p.matcher(pin).matches();
	}

}
