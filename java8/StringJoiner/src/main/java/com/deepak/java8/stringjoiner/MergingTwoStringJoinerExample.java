package com.deepak.java8.stringjoiner;

//importing StringJoiner class  
import java.util.StringJoiner;

public class MergingTwoStringJoinerExample {
	public static void main(String[] args) {

		StringJoiner joinNames = new StringJoiner(",", "[", "]"); // passing comma(,) and square-brackets as delimiter

		// Adding values to StringJoiner
		joinNames.add("Deepak");
		joinNames.add("Kumar");

		// Creating StringJoiner with :(colon) delimiter
		StringJoiner joinNames2 = new StringJoiner(":", "[", "]"); // passing colon(:) and square-brackets as delimiter

		// Adding values to StringJoiner
		joinNames2.add("Tushar");
		joinNames2.add("Sharma");

		// Merging two StringJoiner
		StringJoiner merge = joinNames.merge(joinNames2);
		System.out.println(merge);
	}
}
