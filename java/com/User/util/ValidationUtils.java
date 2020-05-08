package com.User.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidationUtils {

	public static boolean isEmpty(String param) {
		boolean isEmpty = false;
		if (param == "" || param.trim().length() <= 0) {
			isEmpty = true;
		}
		return isEmpty;
	}

		public static boolean isContactValid(String num) {
	
		boolean res = true;
		Pattern p = Pattern.compile("[6789]\\d{10}");
		Matcher m = p.matcher(num);
		
		if(m.matches()) {
			res = false;
		}
	
	

	return res;
	}
}
