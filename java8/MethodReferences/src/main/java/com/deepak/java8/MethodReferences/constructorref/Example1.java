package com.deepak.java8.MethodReferences.constructorref;

interface Messageable {
	Message getMessage(String msg);
}

class Message {
	Message(String msg) {
		System.out.print(msg);
	}
}

public class Example1 {
	public static void main(String[] args) {
		Messageable hello = Message::new;
		hello.getMessage("Hello Deepak");
	}
}