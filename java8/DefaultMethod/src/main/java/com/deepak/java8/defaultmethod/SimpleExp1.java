package com.deepak.java8.defaultmethod;

interface Sayable{  
    // Default method   
    default void say(){  
        System.out.println("Hello, this is default method written by Deepak");  
    }  
    // Abstract method  
    void sayMore(String msg);  
}  
public class SimpleExp1 implements Sayable{  
    public void sayMore(String msg){        // implementing abstract method   
        System.out.println(msg);  
    }  
    public static void main(String[] args) {  
    	SimpleExp1 dm = new SimpleExp1();  
        dm.say();   // calling default method  
        dm.sayMore("Work is worship");  // calling abstract method  
  
    }  
} 
