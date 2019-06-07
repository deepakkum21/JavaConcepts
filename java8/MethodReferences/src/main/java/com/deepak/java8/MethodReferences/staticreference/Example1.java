package com.deepak.java8.MethodReferences.staticreference;

interface Sayable{  
    void say(); 
}  
public class Example1 {  
    public static void saySomething(){  
        System.out.println("Hello, this is static method.");  
    }  
    public static void main(String[] args) {  
        // Referring static method  
        Sayable sayable = Example1::saySomething;  
        // Calling interface method  
        sayable.say();  
    }  
}  