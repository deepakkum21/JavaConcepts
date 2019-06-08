# Java Default Methods

- Java provides a facility **to create default methods inside the interface**. 
- Methods which are defined inside the interface and tagged with default are known as default methods. 
- These methods **are non-abstract methods**.
- The concept of default method is used to define a method with default implementation. 
- You can override default method also to provide more specific implementation for the method.
- The main concept of introducing the default method so if a user wants to add a method, then the user has to    implement that method in evry implemented class, but by defining the method as default the user is not forced to provide the implementation, so its his decision he can change the implementation by overriding the default method or simply he can call the default method with default implementation.

## Example
1. **Simple** 

            interface Sayable{  
                // Default method   
                default void say(){  
                    System.out.println("Hello, this is default method");  
                }  
                // Abstract method  
                void sayMore(String msg);  
            }  
            public class DefaultMethods implements Sayable{  
                public void sayMore(String msg){        // implementing abstract method   
                    System.out.println(msg);  
                }  
                public static void main(String[] args) {  
                    DefaultMethods dm = new DefaultMethods();  
                    dm.say();   // calling default method  
                    dm.sayMore("Work is worship");  // calling abstract method  
            
                }  
            } 