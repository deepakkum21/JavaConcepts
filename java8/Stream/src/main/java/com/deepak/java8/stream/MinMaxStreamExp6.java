package com.deepak.java8.stream;

import java.util.*;

class Product4{
	int id;
	String name;
	float price;

	public Product4(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
}

public class MinMaxStreamExp6 {
	public static void main(String[] args) {
		List<Product4> productsList = new ArrayList<Product4>();
		// Adding Products
		productsList.add(new Product4(1, "HP Laptop", 25000f));
		productsList.add(new Product4(2, "Dell Laptop", 30000f));
		productsList.add(new Product4(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product4(4, "Sony Laptop", 28000f));
		productsList.add(new Product4(5, "Apple Laptop", 90000f));
		// max() method to get max Product price
		Product4 productA = productsList.stream().max((product1, product2) -> product1.price > product2.price ? 1 : -1)
				.get();

		System.out.println("maximmum price: "+productA.price);
		// min() method to get min Product price
		Product4 productB = productsList.stream().max((product1, product2) -> product1.price < product2.price ? 1 : -1)
				.get();
		System.out.println("minimmum price: "+productB.price);

	}
}
