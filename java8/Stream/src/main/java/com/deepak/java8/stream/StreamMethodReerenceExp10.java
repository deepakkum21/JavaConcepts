package com.deepak.java8.stream;

import java.util.*;  
import java.util.stream.Collectors;  
  
class Product10{  
    int id;  
    String name;  
    float price;  
      
    public Product10(int id, String name, float price) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
          
    public int getId() {  
        return id;  
    }  
    public String getName() {  
        return name;  
    }  
    public float getPrice() {  
        return price;  
    }  
}  
  
public class StreamMethodReerenceExp10 {  
  
    public static void main(String[] args) {  
          
        List<Product10> productsList = new ArrayList<Product10>();  
          
        //Adding Products  
        productsList.add(new Product10(1,"HP Laptop",25000f));  
        productsList.add(new Product10(2,"Dell Laptop",30000f));  
        productsList.add(new Product10(3,"Lenevo Laptop",28000f));  
        productsList.add(new Product10(4,"Sony Laptop",28000f));  
        productsList.add(new Product10(5,"Apple Laptop",90000f));  
          
        List<Float> productPriceList =   
                productsList.stream()  
                            .filter(p -> p.price > 30000) // filtering data  
                            .map(Product10::getPrice)         // fetching price by referring getPrice method  
                            .collect(Collectors.toList());  // collecting as list  
        System.out.println(productPriceList);  
    }  
} 
