package com.deepak.java8.functionalinterfaces;

@FunctionalInterface
interface sayable1 {
	void say(String msg); // abstract method
	// It can contain any number of Object class methods.

	int hashCode();

	String toString();

	boolean equals(Object obj);
}

public class Example2 implements sayable1 {
	public void say(String msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) {
		Example2 fie = new Example2();
		fie.say("Hello Deepak");
	}
}