## Java Method References
- Method reference is used to refer method of functional interface. 
- It is compact and easy form of lambda expression. 
- Each time when you are using lambda expression to just referring a method, you can replace your lambda expression with method reference.

## Types of Method References
1. Reference to a static method.
2. Reference to an instance method.
3. Reference to a constructor.

## 1. Reference to a Static Method
`ContainingClass::staticMethodName  `

            interface Sayable{  
                void say();  
            }  
            public class MethodReference {  
                public static void saySomething(){  
                    System.out.println("Hello, this is static method.");  
                }  
                public static void main(String[] args) {  
                    // Referring static method  
                    Sayable sayable = MethodReference::saySomething;  
                    // Calling interface method  
                    sayable.say();  
                }  
            }  


            public class MethodReference2 {  
                public static void ThreadStatus(){  
                    System.out.println("Thread is running...");  
                }  
                public static void main(String[] args) {  
                    Thread t2=new Thread(MethodReference2::ThreadStatus);  
                    t2.start();       
                }  
            } 



            import java.util.function.BiFunction;  
            class Arithmetic{  
                    public static int add(int a, int b){  
                    return a+b;  
                }  
            }  
            public class MethodReference3 {  
                    public static void main(String[] args) {  
                    BiFunction<Integer, Integer, Integer>adder = Arithmetic::add;  
                    int result = adder.apply(10, 20);  
                    System.out.println(result);  
                }  
            }  



            import java.util.function.BiFunction;  
            class Arithmetic{  
                public static int add(int a, int b){  
                    return a+b;  
                }  
                public static float add(int a, float b){  
                    return a+b;  
                }  
                public static float add(float a, float b){  
                    return a+b;  
                }  
            }  
            public class MethodReference4 {  
                public static void main(String[] args) {  
                    BiFunction<Integer, Integer, Integer>adder1 = Arithmetic::add;  
                    BiFunction<Integer, Float, Float>adder2 = Arithmetic::add;  
                    BiFunction<Float, Float, Float>adder3 = Arithmetic::add;  
                    int result1 = adder1.apply(10, 20);  
                    float result2 = adder2.apply(10, 20.0f);  
                    float result3 = adder3.apply(10.0f, 20.0f);  
                    System.out.println(result1);  
                    System.out.println(result2);  
                    System.out.println(result3);  
                }  
            } 


## 2) Reference to an Instance Method
` containingObject::instanceMethodName  `

            interface Sayable{  
                void say();  
            }  
            public class InstanceMethodReference {  
                public void saySomething(){  
                    System.out.println("Hello, this is non-static method.");  
                }  
                public static void main(String[] args) {  
                    InstanceMethodReference methodReference = new InstanceMethodReference(); // Creating object  
                    // Referring non-static method using reference  
                        Sayable sayable = methodReference::saySomething;  
                    // Calling interface method  
                        sayable.say();  
                        // Referring non-static method using anonymous object  
                        Sayable sayable2 = new InstanceMethodReference()::saySomething; // You can use anonymous object also  
                        // Calling interface method  
                        sayable2.say();  
                }  
            }



            public class InstanceMethodReference2 {  
                public void printnMsg(){  
                    System.out.println("Hello, this is instance method");  
                }  
                public static void main(String[] args) {  
                Thread t2=new Thread(new InstanceMethodReference2()::printnMsg);  
                    t2.start();       
                }  
            }



            import java.util.function.BiFunction;  
            class Arithmetic{  
                public int add(int a, int b){  
                    return a+b;  
                }  
            }  
            public class InstanceMethodReference3 {  
                public static void main(String[] args) {  
                    BiFunction<Integer, Integer, Integer>adder = new Arithmetic()::add;  
                    int result = adder.apply(10, 20);  
                    System.out.println(result);  
                }  
            }    



## 3) Reference to a Constructor
`   ClassName::new  `

            interface Messageable{  
                Message getMessage(String msg);  
            }  
            class Message{  
                Message(String msg){  
                    System.out.print(msg);  
                }  
            }  
            public class ConstructorReference {  
                public static void main(String[] args) {  
                    Messageable hello = Message::new;  
                    hello.getMessage("Hello");  
                }  
            }

            