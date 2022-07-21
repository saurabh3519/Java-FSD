package com.simplilearn.project2;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EmailValidation {
	
	public static boolean EmailIsValid(String email) {
		String regex = "[a-zA-Z][\\w-]{1,20}@\\w{2,20}\\.\\w{2,3}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher mathcer = pattern.matcher(email);
		return mathcer.matches();
		
	}
	public static void main(String[] args) {
		String email = "saurabhsingh3519@gmai.com";
		boolean valid = EmailIsValid(email);
		if(valid)
			System.out.println(email + " is valid");
		else
			System.out.println(email + " is not valid");
	}

}
