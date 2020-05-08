package com.Donation.util;

public class ValidationUtils {

	public static boolean isEmptyString(String param){
		boolean isEmptyString = false;
		if(param=="" || param.trim().length()<=0){
			isEmptyString = true;
		}
		return isEmptyString;
	}//end isEmptyString
}//end class
	
	

