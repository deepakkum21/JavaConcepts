package com.deepak.java8.stream;

import java.util.stream.*;

public class StreamIteratingExp2 {
	public static void main(String[] args) {
		Stream.iterate(2, element -> element + 2).filter(element -> element % 5 == 0).limit(10)
				.forEach(System.out::println);
	}
}
