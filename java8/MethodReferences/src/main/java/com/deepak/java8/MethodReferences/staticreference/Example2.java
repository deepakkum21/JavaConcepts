package com.deepak.java8.MethodReferences.staticreference;

public class Example2 {
	public static void ThreadStatus(){  
        System.out.println("Thread is running...");  
    }  
    public static void main(String[] args) {  
        Thread t2=new Thread(Example2::ThreadStatus);  
        t2.start();       
    } 
}
