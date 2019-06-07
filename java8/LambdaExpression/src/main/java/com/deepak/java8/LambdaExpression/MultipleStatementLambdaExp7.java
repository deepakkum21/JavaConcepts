package com.deepak.java8.LambdaExpression;

@FunctionalInterface  
interface SayableExp{  
    String say(String message);  
}  
  
public class MultipleStatementLambdaExp7{  
    public static void main(String[] args) {  
      
        // You can pass multiple statements in lambda expression  
    	SayableExp person = (message)-> {  
            String str1 = "I would like to say, ";  
            String str2 = str1 + message;   
            return str2;  
        };  
            System.out.println(person.say("Be Normal, Be Happy."));  
    }  
}
