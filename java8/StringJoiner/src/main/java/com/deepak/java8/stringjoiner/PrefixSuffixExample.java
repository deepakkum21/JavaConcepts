package com.deepak.java8.stringjoiner;

// importing StringJoiner class  
import java.util.StringJoiner;

public class PrefixSuffixExample {  
    public static void main(String[] args) {  
        StringJoiner joinNames = new StringJoiner(",", "[", "]");   // passing comma(,) and square-brackets as delimiter   
        
        // Adding values to StringJoiner  
        joinNames.add("Rahul");  
        joinNames.add("Raju");  
        joinNames.add("Peter");  
        joinNames.add("Raheem");  
                
        System.out.println(joinNames);  
    }  
}  