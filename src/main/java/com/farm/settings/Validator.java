

package com.farm.settings;


public class Validator {
	public static String uniqueValidationMessage(String fieldName) {
		return fieldName + " is already taken!!!";
	}
	
	public static boolean isValid(String email) {
	      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      return email.matches(regex);
	}
}
