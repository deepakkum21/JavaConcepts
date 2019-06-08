# Java ForEach Loop
- Java provides a new method **forEach() to iterate the elements**. 
- It is **defined in Iterable and Stream interface**. 
- It is a default method defined in the Iterable interface. 
- Collection classes which extends Iterable interface can use forEach loop to iterate elements.
- This method **takes a single parameter which is a functional interface**. So, you **can pass lambda expression as an argument**.

## Signature
**`default void forEach(Consumer<super T>action) `**

### 1. Example

            import java.util.ArrayList;  
            import java.util.List;  
            public class ForEachExample {  
                public static void main(String[] args) {  
                    List<String> gamesList = new ArrayList<String>();  
                    gamesList.add("Football");  
                    gamesList.add("Cricket");  
                    gamesList.add("Chess");  
                    gamesList.add("Hocky");  
                    System.out.println("------------Iterating by passing lambda expression--------------");  
                    gamesList.forEach(games -> System.out.println(games));  
                    
                }  
            }


### 2. Example

            import java.util.ArrayList;  
            import java.util.List;  
            public class ForEachExample {  
                public static void main(String[] args) {  
                    List<String> gamesList = new ArrayList<String>();  
                    gamesList.add("Football");  
                    gamesList.add("Cricket");  
                    gamesList.add("Chess");  
                    gamesList.add("Hocky");  
                    System.out.println("------------Iterating by passing method reference---------------");  
                    gamesList.forEach(System.out::println);  
                }  
            }  