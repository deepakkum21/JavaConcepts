package com.deepak.java8.MethodReferences.instancemethodref;

interface Sayable{  
    void say();  
}  
public class Example1 {  
    public void saySomething(){  
        System.out.println("Hello, this is non-static method.");  
    }  
    public static void main(String[] args) {  
    	Example1 methodReference = new Example1(); // Creating object  
    	
        // Referring non-static method using reference  
        Sayable sayable = methodReference::saySomething;
        
        // Calling interface method  
        sayable.say();
        
        // Referring non-static method using anonymous object  
        Sayable sayable2 = new Example1()::saySomething; 
        // You can use anonymous object also
        
        // Calling interface method  
        sayable2.say();  
    }  
}
