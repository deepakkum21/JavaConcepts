package com.deepak.java8.LambdaExpression;

interface Sayable {
	public String say();
}

public class NoParameterLambdaExp2 {
	public static void main(String[] args) {
		Sayable s = () -> {
			return "I have nothing to say.";
		};
		System.out.println(s.say());
	}
}