package com.deepak.java8.optional;

import java.util.Optional;

public class Example2 {
	public static void main(String[] args) {  
        String[] str = new String[10];        
        str[5] = "JAVA OPTIONAL CLASS EXAMPLE";// Setting value for 5th index  
        Optional<String> checkNull = Optional.ofNullable(str[5]);  
        if(checkNull.isPresent()){  // It Checks, value is present or not  
            String lowercaseString = str[5].toLowerCase();  
            System.out.print(lowercaseString);  
        }else  
            System.out.println("String value is not present");  
        
        checkNull.ifPresent(System.out::println);   // printing value by using method reference  
        System.out.println(checkNull.get());    // printing value by using get method  
    }  
}
