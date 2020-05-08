package com.Event.util;

public class ValidationUtils {

	public static boolean isEmpty(String param){
		boolean isEmpty = false;
		if(param=="" || param.trim().length()<=0){
			isEmpty = true;
		}
		return isEmpty;
	}
	
	
	public static boolean isContactValid(String param)
	{
		boolean isContactValid = false;
if(ValidationUtils.isContactValid("9000000000")) {
			
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		
		return isContactValid;
	}
	

}
