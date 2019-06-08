# Java Stream Filter
1. Java stream provides a method filter() to filter stream elements on the basis of given predicate. 
2. Suppose you want to get only even elements of your list then you can do this easily with the help of filter method.
3. This method **takes predicate as an argument** and **returns a stream of consisting of resulted elements**.

## Signature
**`Stream<T> filter(Predicate<? super T> predicate)  `**

- predicate: It **takes Predicate reference as an argument**. Predicate is a functional interface. So, you can **also pass lambda expression here**

## Example

            import java.util.*;  
            class Product{  
                int id;  
                String name;  
                float price;  
                public Product(int id, String name, float price) {  
                    this.id = id;  
                    this.name = name;  
                    this.price = price;  
                }  
            }  
            public class JavaStreamExample {  
                public static void main(String[] args) {  
                    List<Product> productsList = new ArrayList<Product>();  
                    //Adding Products  
                    productsList.add(new Product(1,"HP Laptop",25000f));  
                    productsList.add(new Product(2,"Dell Laptop",30000f));  
                    productsList.add(new Product(3,"Lenevo Laptop",28000f));  
                    productsList.add(new Product(4,"Sony Laptop",28000f));  
                    productsList.add(new Product(5,"Apple Laptop",90000f));  
                    productsList.stream()  
                                .filter(p ->p.price> 30000)   // filtering price  
                                .map(pm ->pm.price)          // fetching price  
                                .forEach(System.out::println);  // iterating price  
                }  
            }




            import java.util.*;  
            import java.util.stream.Collectors;  
            class Product{  
                int id;  
                String name;  
                float price;  
                public Product(int id, String name, float price) {  
                    this.id = id;  
                    this.name = name;  
                    this.price = price;  
                }  
            }  
            public class JavaStreamExample {  
                public static void main(String[] args) {  
                    List<Product> productsList = new ArrayList<Product>();  
                    //Adding Products  
                    productsList.add(new Product(1,"HP Laptop",25000f));  
                    productsList.add(new Product(2,"Dell Laptop",30000f));  
                    productsList.add(new Product(3,"Lenevo Laptop",28000f));  
                    productsList.add(new Product(4,"Sony Laptop",28000f));  
                    productsList.add(new Product(5,"Apple Laptop",90000f));  
                    List<Float> pricesList =  productsList.stream()  
                                .filter(p ->p.price> 30000)   // filtering price  
                                .map(pm ->pm.price)          // fetching price  
                                .collect(Collectors.toList());  
                    System.out.println(pricesList);  
                }  
            }  