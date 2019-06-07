package com.deepak.java8.LambdaExpression;


interface SayableExp3{  
    public String say(String name);  
}  
  
public class SingleParameterlambdaExp3{  
    public static void main(String[] args) {  
      
        // Lambda expression with single parameter.  
    	SayableExp3 s1=(name)->{  
            return "Hello, "+name;  
        };  
        System.out.println(s1.say("Deepak"));  
          
        // You can omit function parentheses    
        SayableExp3 s2= name ->{  
            return "Hello, "+name;  
        };  
        System.out.println(s2.say("Deepak"));  
    }  
}