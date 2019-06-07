package com.deepak.java8.LambdaExpression;

import java.util.*;

public class ForEachLambdaExp6 {
	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("Deepak");
		list.add("Nimisha");
		list.add("Tushar");
		list.add("Dida");
		list.add("Ashif");

		list.forEach((n) -> System.out.println(n));
	}
}
