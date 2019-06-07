package com.deepak.java8.LambdaExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class ProductExp {
	int id;
	String name;
	float price;

	public ProductExp(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
}

public class FilterCollectionLambdaExp10 {
	public static void main(String[] args) {
		List<ProductExp> list = new ArrayList<>();
		list.add(new ProductExp(1, "Samsung A80", 17000f));
		list.add(new ProductExp(3, "Iphone XR", 65000f));
		list.add(new ProductExp(2, "Google Pixel", 25000f));
		list.add(new ProductExp(4, "Pocco F1", 15000f));
		list.add(new ProductExp(5, "Redmi4 ", 26000f));
		list.add(new ProductExp(6, "Asus Zenfone", 19000f));

		// using lambda to filter data
		Stream<ProductExp> filtered_data = list.stream().filter(p -> p.price > 20000);

		// using lambda to iterate through collection
		filtered_data.forEach(product -> System.out.println(product.name + ": " + product.price));
	}
}
