package com.deepak.java8.optional;

import java.util.Optional;

public class Example1 {
	public static void main(String[] args) {
		String[] str = new String[10];
		try {
			String lowercaseString = str[5].toLowerCase();
			System.out.print(lowercaseString);
		} catch (NullPointerException npe) {
			System.out.println("NPE was encountered");
		}

		
		// If Value is not Present
		Optional<String> checkNull = Optional.ofNullable(str[5]);
		if (checkNull.isPresent()) {

			// check for value is present or not
			String lowerCaseString = str[5].toLowerCase();
			System.out.print(lowerCaseString);
		} else
			System.out.println("string value is not present");
	}

}
