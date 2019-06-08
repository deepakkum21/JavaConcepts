package com.deepak.java8.collectors;

import java.util.stream.Collectors;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

class Product2 {
	int id;
	String name;
	float price;

	public Product2(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
}

public class ConvertingDataAsSet {
	public static void main(String[] args) {
		List<Product2> productsList = new ArrayList<>();
		// Adding Products
		productsList.add(new Product2(1, "HP Laptop", 25000f));
		productsList.add(new Product2(2, "Dell Laptop", 30000f));
		productsList.add(new Product2(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product2(4, "Sony Laptop", 28000f));
		productsList.add(new Product2(5, "Apple Laptop", 90000f));
		Set<Float> productPriceList = productsList.stream().map(x -> x.price) // fetching price
				.collect(Collectors.toSet()); // collecting as list
		System.out.println(productPriceList);
	}
}
