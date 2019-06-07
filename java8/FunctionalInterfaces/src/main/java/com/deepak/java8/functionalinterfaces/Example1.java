package com.deepak.java8.functionalinterfaces;

@FunctionalInterface  
interface sayable{  
    void say(String msg);  
}  
public class Example1 implements sayable{  
    public void say(String msg){  
        System.out.println(msg);  
    }  
    public static void main(String[] args) {  
    	Example1 fie = new Example1();  
        fie.say("Hello there");  
    }  
}  
