package com.deepak.java8.stream;

import java.util.*;
import java.util.stream.Collectors;

class Product3 {
	int id;
	String name;
	float price;

	public Product3(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
}

public class SumUsingCollectorsExp5 {
	public static void main(String[] args) {
		List<Product3> productsList = new ArrayList<Product3>();
		// Adding Products
		productsList.add(new Product3(1, "HP Laptop", 25000f));
		productsList.add(new Product3(2, "Dell Laptop", 30000f));
		productsList.add(new Product3(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product3(4, "Sony Laptop", 28000f));
		productsList.add(new Product3(5, "Apple Laptop", 90000f));
		// Using Collectors's method to sum the prices.
		double totalPrice3 = productsList.stream().collect(Collectors.summingDouble(product -> product.price));
		System.out.println(totalPrice3);

	}
}
