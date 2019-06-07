## JAVA 8 SAMPLE EXAMPLES

#Java 8 Features
Oracle released a new version of Java as Java 8 in March 18, 2014. It was a revolutionary release of the Java for software development platform. It includes various upgrades to the Java programming, JVM, Tools and libraries.

## Java 8 Programming Language Enhancements
Java 8 provides following features for Java Programming:

- Lambda expressions,
- Method references,
- Functional interfaces,
- Stream API,
- Default methods,
- Base64 Encode Decode,
- Static methods in interface,
- Optional class,
- Collectors class,
- ForEach() method,
- Parallel array sorting,
- Nashorn JavaScript Engine,
- Parallel Array Sorting,
- Type and Repating Annotations,
- IO Enhancements,
- Concurrency Enhancements,
- JDBC Enhancements etc.

## Lambda Expressions
- Lambda expression helps us to write our code in functional style. 
- It provides a clear and concise way to implement SAM interface(Single Abstract Method) by using an expression. 
- It is very useful in collection library in which it helps to iterate, filter and extract data.

## Method References
- Java 8 Method reference is used to refer method of functional interface . 
- It is compact and easy form of lambda expression. 
- Each time when you are using lambda expression to just referring a method, you can replace your lambda expression with method reference.

## Functional Interface
- An Interface that contains only one abstract method is known as functional interface. 
- It can have any number of default and static methods. 
- It can also declare methods of object class.
- Functional interfaces are also known as Single Abstract Method Interfaces (SAM Interfaces).

## Optional
- Java introduced a new class Optional in Java 8. 
- It is a public final class which is used to deal with NullPointerException in Java application. 
- We must import java.util package to use this class. 
- It provides methods to check the presence of value for particular variable.

## forEach
- Java provides a new method forEach() to iterate the elements. 
- It is defined in Iterable and Stream interfaces.
- It is a default method defined in the Iterable interface. 
- Collection classes which extends Iterable interface can use forEach() method to iterate elments.
- This method takes a single parameter which is a **functional interface. So, you can pass lambda expression as an argument.**

## Default Methods in Interface
- Java provides a facility to create default methods inside the interface. 
- Methods which are defined inside the interface and tagged with default keyword are known as default methods. 
- These methods are non-abstract methods and can have method body.

## StringJoiner
- Java added a new final class StringJoiner in java.util package. 
- It is used to construct a sequence of characters separated by a delimiter. 
- Now, you can create string by passing delimiters like comma(,), hyphen(-) etc.

## Collectors
- Collectors is a final class that extends Object class. 
- It provides reduction operations, such as accumulating elements into collections, summarizing elements according to various criteria etc.

## Stream API
- Java 8 java.util.stream package consists of classes, interfaces and an enum to allow functional-style operations on the elements. 
- It performs lazy computation. So, it executes only when it requires.

## Stream Filter
- Java stream provides a method filter() to filter stream elements on the basis of given predicate. 
- Suppose, you want to get only even elements of your list, you can do this easily with the help of filter() method.
- This method takes predicate as an argument and returns a stream of resulted elements.

## Stream Filter
- Java stream provides a method filter() to filter stream elements on the basis of given predicate. 
- Suppose, you want to get only even elements of your list, you can do this easily with the help of filter() method.
- This method takes predicate as an argument and returns a stream of resulted elements.