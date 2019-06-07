package com.deepak.java8.MethodReferences.instancemethodref;

public class Example2 {
	public void printnMsg() {
		System.out.println("Hello, this is instance method");
	}

	public static void main(String[] args) {
		Thread t2 = new Thread(new Example2()::printnMsg);
		t2.start();
	}
}
