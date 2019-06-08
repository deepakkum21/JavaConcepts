package com.deepak.java8.streamfilter;

import java.util.*;  
class Product1{  
    int id;  
    String name;  
    float price;  
    public Product1(int id, String name, float price) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
}  
public class Example1 {  
    public static void main(String[] args) {  
        List<Product1> productsList = new ArrayList<>();  
        //Adding Products  
        productsList.add(new Product1(1,"HP Laptop",25000f));  
        productsList.add(new Product1(2,"Dell Laptop",30000f));  
        productsList.add(new Product1(3,"Lenevo Laptop",28000f));  
        productsList.add(new Product1(4,"Sony Laptop",28000f));  
        productsList.add(new Product1(5,"Apple Laptop",90000f));  
        productsList.stream()  
                    .filter(p ->p.price> 30000)   // filtering price  
                    .map(pm ->pm.price)          // fetching price  
                    .forEach(System.out::println);  // iterating price  
    }  
}
