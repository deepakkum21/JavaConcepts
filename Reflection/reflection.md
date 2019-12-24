# Reflection in Java?

## What
1. Java Reflection is the **process of analyzing and modifying all the capabilities of a class at runtime**. 
2. API in Java is **used to manipulate class and its members** which **include fields, methods, constructor, etc. at runtime**.
3. One **advantage** of reflection API in Java is, **it can manipulate private members of the class too**.
4. The **java.lang.reflect package provides many classes to implement reflection** java.Methods of the **java.lang.Class class is used to gather the complete metadata of a particular class**.

## Few real examples of Reflection
1. Code analyzer tools
2. Eclipse (Other IDEs) auto completion of method names
3. Spring Framework for creating the beans
    - Spring framework uses dependency injection (DI) to populate the dependencies into beans defined in config files. DI framework actually heavily uses reflection for injecting these bean dependencies.
    - Spring 3 onwards, you can define the dependencies using annotations as well, using autowiring. Annotations are analyzed for dependencies injection using reflection only.
4. Junit Testcases
    - previous versions of Junit, then to run a testcase all you cad to do, was name a method starting with test e.g. testMethod1(), testCode2() etc. Junit processor was using reflection to iterate over all methods in class, and find-out methods starting with test and run this as testcase.
5. Parsing annotations by ORMs like hibernate entity
    - ORMs like hibernate use the config files (not they use annotations) for defining the relationship between entities and relationship between entity and database schemas. All this information is processed using java reflection capability.

## Class in java.lang.reflect Package
1. **Field**: 
    - This class is used to gather declarative **information such as datatype, access modifier, name and value of a variable**.
2. **Method**: 
    - This class is used to gather declarative **information such as access modifier, return type, name, parameter types and exception type of a method**.
3. **Constructor**: 
    - This class is used to gather declarative **information such as access modifier, name and parameter types of a constructor**.
4. **Modifier**: 
    - This class is used to gather information **about a particular access modifier**.

## Methods used in java.lang.Class 
- The java.lang.Class class performs mainly two tasks:
    - **provides methods to get the metadata of a class at run time**.
    - **provides methods to examine and change the run time behavior of a class**.
1. **Public String getName ()**:
    - Returns the name of the class.
2. **public Class getSuperclass()**:
    - Returns the super class reference
3. **Public Class[] getInterfaces()** :
    - Returns an array of interfaces implemented by the specified class
4. **Public in getModifiers ()**:
    - Returns an integer value representing the modifiers of the specified class which needs to be passed as a parameter to "public static String toString (int i )" method which returns the access specifier for the given class.

## Commonly used methods of Class class:
| **S.No.** | **Method** |	**Description** |            
| --------- | ---------- | ---------------- |          
| 1 | public String getName() |	returns the class name |
| 2 | public static Class forName(String className)throws ClassNotFoundException |	loads the class and returns the reference of Class class. |
| 3 | public Object newInstance()throws InstantiationException,IllegalAccessException |	creates new instance. |
| 4 | public boolean isInterface() |	checks if it is interface. |
| 5 | public boolean isArray() |	checks if it is array. |
| 6 | public boolean isPrimitive() |	checks if it is primitive. |
| 7 | public Class getSuperclass() |	returns the superclass class reference. |
| 8 | public Field[] getDeclaredFields()throws SecurityException |	returns the total number of fields of this class. |
| 9 | public Method[] getDeclaredMethods()throws SecurityException |	returns the total number of methods of this class. |
| 10 | public Constructor[] getDeclaredConstructors()throws SecurityException |	returns the total number of constructors of this class. |
| 11 | public Method getDeclaredMethod(String name,Class[] parameterTypes)throws NoSuchMethodException,SecurityException |	returns the method class instance. |

## How to get the object of Class class?
There are 3 ways to get the instance of Class class. They are as follows:
- **forName("full Qulaified name of the class")** method of Class class
- **getClass()** method of Object class
- **.class** 
1. **forName() method of Class class**
    - is **used to load the class dynamically**.
    - **returns the instance of Class class**.
    - It should be **used if you know the fully qualified name of class**.
    - This **cannot be used for primitive types**.
2. **getClass() method of Object class**
    - It **returns the instance of Class** class. 
    - It should be used **if you know the type**. 
    - It can be **used with primitives**.
3. **.class** syntax
    - If a **type is available but there is no instance then it is possible to obtain a Class** by appending ".class" to the name of the type.
    - It can be **used for primitive data type** also.    

## How to get complete information about a class
-           package com.deepak;

            public class MyClassInfo {
                public static void main(String[] args) throws ClassNotFoundException {
                    // 1 - By using Class.forname() method
                    Class<?> c1 = Class.forName("com.deepak.MyClassInfo");
                    System.out.println(c1);
                    // 2- By using getClass() method
                    MyClassInfo classInfo = new MyClassInfo();
                    Class<? extends MyClassInfo> c2 = classInfo.getClass();
                    System.out.println(c2);
                    // 3- By using .class
                    @SuppressWarnings("rawtypes")
                    Class c3 = MyClassInfo.class;
                    System.out.println(c3);
                }
            }

## How to get Metadata of Class
- MetaData of a class includes            
    - **Class**
    - **super class name**
    - **implemented interfaces**
    - **access modifiers of a class.**
- eg Metadata of following class would be like:-
-           import java.io.Serializable;
                public abstract class ClassMetaData implements Serializable,Cloneable {
            }
    - Name of the class is: ClassMetaData
    - It's access modifiers are: public and abstract
    - It has implemented interfaces: Serializable and Cloneable
    - Since it has not extended any class explicitly, it's super class is: java.lang.Object

- Below class will get the meta data of ClassMetaData.class and print it:
-           public class MyClassMetaDataInfo {
                public static void main (String [] args) throws ClassNotFoundException { 
                    // Create Class object for ClassMetaData.class 
                    Class classMetaDataObj = ClassMetaData.class;
                    
                    // Print name of the class 
                    System.out.println("Name of the class is : " +classMetaDataObj.getName());
                    
                    // Print Super class name
                    System.out.println("Name of the super class is : " +classMetaDataObj.getSuperclass().getName());
                    
                    // Get the list of implemented interfaces in the form of Class array using getInterface() method
                    Class[] interfaceList = classMetaDataObj.getInterfaces();
                    
                    // Print the implemented interfaces using foreach loop 
                    System.out.print("Implemented interfaces are : ");
                    for (Class classOfInterface : interfaceList)	{
                        System.out.print(classOfInterface.getName() + ", ");
                    }
                    System.out.println();
                    
                    //Get access modifiers using get Modifiers() method and toString() method of java.lang.reflect.Modifier class
                    int accessModifier= classMetaDataObj.getModifiers(); 
                    // Print the access modifiers
                    System.out.println("Access modifiers of the class are : " +Modifier.toString(accessModifier));
                    
                }
            }

            public abstract class ClassMetaData implements Serializable,Cloneable {
            }

## How to get Metadata of Variable
-           package com.deepak;

            public class VariableMetaData {				
                        public static int intVar1=1111;
                        static int intVar2=2222;							
                        static String stringVar1="reflection";							
                        static String stringVar2="Learning Reflection API";    
            }

### **Steps to get the metadata about the variables in the above class**:
1. Create the class object of the above class i.e VariableMetaData.class
-           VariableMetaData variableObject = new VariableMetaData();
            Class variableClass = variableObject.getClass();
2. Get the metadata in the form of field array using getFields() or getDeclaredFields() methods as below:
-   `Field[] fields = variableClass.getFields();`                      // returns metadata of the public variable from the specified class/interface as well as from its super class/interface
-   `Field[] declaredFields = variableClass.getDeclaredFields();`      // returns metadata of the all the variables from the specified class only
3. Get the **name of the variables** using **"public String getName()"** method.
4. Get the **datatype of the variables** using **"public Class getType()"** method.
5. Get the **value of the variable** using **"public xxx get (Field)"** method.
    - Here, xxx could be a byte or short of any type of value we want to fetch.
6. Get the **access modifiers of the variables** using **getModifier() and Modifier.toString(int i)** methods.
-           package com.deepak;

            import java.lang.reflect.Field;
            import java.lang.reflect.Modifier;

            public class VariableMetaData extends Super{
                public static int intVar1 = 1111;
                static int intVar2 = 2222;
                public int[] intArray = new int[] { 5, 6, 7 };
                static String stringVar1 = "reflection";
                static String stringVar2 = "Learning Reflection API";

                public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {

                    // Class variableClass = VariableMetaData.class;
                    VariableMetaData variableObject = new VariableMetaData();
                    Class variableClass = variableObject.getClass();
                    Field[] fields = variableClass.getFields();
                    Field[] declaredFields = variableClass.getDeclaredFields();

                    for (Field f : fields) {
                        System.out.println("Field: " + f);
                        System.out.println("Name of the variable: "+ f.getName());
                        System.out.println("Type of the variable: "+ f.getType());
                        // System.out.println("Value of the variable: "+ f.get(f));
                        System.out.println("Modifier of the Variable: " +Modifier.toString(f.getModifiers()));
                    }
                    System.out.println();
                    for (Field f : declaredFields) {
                        System.out.println("declaredFields: " + f);
                        System.out.println("Type of the variable: "+ f.getType());
                        // System.out.println("Value of the variable: "+ f.get(f));
                        System.out.println("Modifier of the Variable: " +Modifier.toString(f.getModifiers()));
                    }
                }

            }

            class Super {
                public static String stringSuperClassVar = "Super Class Var";
            }

## How to get Metadata of Method
-           package com.deepak;

            import java.sql.SQLException;

            public class MethodMetaData {
                public void add(int firstElement, int secondElement, String result)
                        throws ClassNotFoundException, ClassCastException {
                    System.out.println("Demo method for Reflextion  API");
                }

                public String search(String searchString) throws ArithmeticException, InterruptedException {
                    System.out.println("Demo method for Reflection API");
                    return null;
                }

                public void delete(String deleteString) throws SQLException {
                    System.out.println("Demo method for Reflection API");
                }

                public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {

                }

            }
### Steps to get the metadata about the methods in the above class :
1. Create the class object of the above class i.e. MethodMetaData.class as below: 
-           MethodMetaData methodObj = new MethodMetaData();
		    Class MethodMetaDataClass = methodObj.getClass(); 
2. Get method information in a Method array using getMethods() and getDeclaredMethods() method as below:   
- `Method[] methods = methodMetaDataClass.getMethods();`              // returns metadata of the public methods from the specified class as well as from its super class
- `Method[] declaredMethods = methodMetaDataClass.getDeclaredMethods();`    // returns metadata of the all the methods from the specified class only
3. Get the **name of the method** using **getName()** method.
4. Get the **return type of the method** using **getReturnType()** method.
5. Get **access modifiers of the methods** using **getModifiers() and Modifiers.toString(int i)** methods.
6. Get **method parameter types** using **getParameterTypes()** method which returns a class array.
7. Get **thrown exception** using **getExceptionTypes()** method which returns a class array.            
-           package com.deepak;

            import java.lang.reflect.Method;
            import java.lang.reflect.Modifier;
            import java.sql.SQLException;

            public class MethodMetaData extends Super {
                public void add(int firstElement, int secondElement, String result)
                        throws ClassNotFoundException, ClassCastException {
                    System.out.println("Demo method for Reflextion  API");
                }

                public String search(String searchString) throws ArithmeticException, InterruptedException {
                    System.out.println("Demo method for Reflection API");
                    return null;
                }

                public void delete(String deleteString) throws SQLException {
                    System.out.println("Demo method for Reflection API");
                }

                public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
                    MethodMetaData methodObj = new MethodMetaData();
                    Class methodMetaDataClass = methodObj.getClass();
                    Method[] methods = methodMetaDataClass.getMethods();
                    Method[] declaredMethods = methodMetaDataClass.getDeclaredMethods();
                    
                    for(Method method: declaredMethods) {
                        // Print the method names
                        System.out.println("Name of the method : "+method.getName());
                        
                        // Print return type of the methods 
                        System.out.println("Return type of the method : "+method.getReturnType());
                        
                        //Get the access modifier list and print
                        System.out.println("Method access modifiers : "+Modifier.toString(method.getModifiers()));
                        
                        // Get and print parameters of the methods
                        System.out.println("Parameters:  ");
                        Class[] prameterTypeList = method.getParameterTypes();
                        for(Class parameterType: prameterTypeList) {
                            System.out.print(parameterType.getName());
                        }
                        
                        System.out.println("Exceptions:  ");
                        // Get and print exception thrown by the method 
                        Class[] exceptionList = method.getExceptionTypes();
                        for(Class exception: exceptionList) {
                            System.out.print(exception.getName() + "  ");
                        }
                    }
                }

            }

            class Super {
                public void multiply(int firstElement, int secondElement, String result)
                        throws ClassNotFoundException, ClassCastException {
                    System.out.println("Demo method for Reflextion  API");
                }
            }

## How to get Metadata of Constructors
1. Creat class object for ConstructorMetaData.class
2. Get all the **metadata of all the constructors** in a Constructor array using **getConstructors()**
3. Print all the **constructor's names** present in the class ConstructorMetaData.class using **getName()**
4. Print all the **access modifiers** of the constructors in the class ConstructorMetaData.class using **getModifiers() and Modifiers.toString(int i)**
5. Print **parameter types** of the constructors in ConstructorMetaData.class using **getParameterTypes()**
6. Print **exceptions** are thrown by constructors in ConstructorMetaData.class using **getExceptionTypes()** 
-           package com.deepak;

            import java.lang.reflect.Constructor;
            import java.lang.reflect.Modifier;
            import java.rmi.RemoteException;
            import java.sql.SQLException;

            public class ConstructorMetaData {
                public ConstructorMetaData(int no) throws ClassCastException ,ArithmeticException{  }							
                public ConstructorMetaData(int no, String name) throws RemoteException ,SQLException{  }							
                public ConstructorMetaData(int no, String name, String address) throws InterruptedException{  }

                public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
                    // Create Class object for ConstructorMetaData.class 
                    Class constructorMetadataClass = ConstructorMetaData.class;
                    
                    // Get all the constructor information in the Constructor array
                    Constructor[] constructorList = constructorMetadataClass.getConstructors();
                    
                    for(Constructor constructor: constructorList) {
                        // Print name of each constructor
                        System.out.println("Constrcutor name : "+constructor.getName());
                        
                        //Get and print access modifiers of each constructor
                        System.out.println("Constrctor modifier : "+ Modifier.toString(constructor.getModifiers()));
                        
                        // Get and print parameter types 
                        Class[] constructorParameterTypeList = constructor.getParameterTypes();
                        System.out.print ("Constrctor parameter types :"); 
                        for(Class parameterType: constructorParameterTypeList) {
                            System.out.println(parameterType.getName() +" ");
                        }
                        
                        // Get and print exception thrown by constructors
                        Class[] exceptionTypeList = constructor.getExceptionTypes();
                        System.out.println("Exception thrown by constructors :");
                        for(Class exceptionType: exceptionTypeList) {
                            System.out.println(exceptionType.getName() +" ");
                        }
                    }
                }
            }

## newInstance() method of Class class and Constructor class
- The newInstance() method of Class class and Constructor class is **used to create a new instance of the class**.
- Class class => **invoke zero-argument constructor**
- Constructor class => **can invoke any number of arguments**

## **How to call private method from another class in java**
- You can call the private method from outside the class **by changing the runtime behaviour of the class**.
- By the **help of java.lang.Class class and java.lang.reflect.Method class**, we can call private method from any other class.
### -**Required methods of Method class**
1. **public void setAccessible(boolean status) throws SecurityException** 
    - **sets the accessibility** of the method.
2. **public Object invoke(Object method, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException** 
    - used to **invoke the method**.

### -**Required method of Class class**
1. **public Method getDeclaredMethod(String name,Class[] parameterTypes)throws NoSuchMethodException,SecurityException**: 
    - returns a Method object that reflects the specified declared method of the class or interface represented by this Class object.

### **Examples calling private method from another class
1. **private method with No parameter**
    - Access all private methods of the class.
    - Access private method by using method name.
    -       package com.deepak;

            public class Book {
                private String bookName;
                private int length;
                private int width;
                public Book(String bookName, int length, int width) {
                    this.bookName = bookName;
                    this.length = length;
                    this.width = width;
                }
                private int pageArea() {
                    return length * width;
                }
                private String getBookName() {
                    return bookName;
                }
                public void showBookDetail() {
                    System.out.println(pageArea());
                    System.out.println(getBookName());
                }
            }

            package com.deepak;

            import java.lang.reflect.InvocationTargetException;
            import java.lang.reflect.Method;
            import java.lang.reflect.Modifier;

            public class PrivateMethodDemo {

                public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException,
                        InvocationTargetException, NoSuchFieldException, SecurityException, NoSuchMethodException {
                    
                    Book book = new Book("Spring Security", 15, 6);
                    PrivateMethodDemo obj = new PrivateMethodDemo();
                    
                    //print all private methods and their return value
                    obj.printAllPrivateMethods(book);
                    System.out.println("-----------------------");
                    
                    //print private method return value by method name
                    obj.printMethodValue(book, "getBookName");
                }

                //Access all private methods of the class.
                private void printAllPrivateMethods(Book book) {
                    Method[] methodList = Book.class.getDeclaredMethods();
                    for(Method method: methodList) {
                        if(Modifier.isPrivate(method.getModifiers())) {
                            method.setAccessible(true);
                            Object obj = null;
                            try {
                                obj = method.invoke(book, null);
                            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                            System.out.println(method.getName()+" : "+ obj);
                        }
                    }
                }

                //Access private method by using method name.
                private void printMethodValue(Book book, String methodName) throws NoSuchMethodException, SecurityException {
                    Method method = Book.class.getDeclaredMethod(methodName, null);	
                    if(Modifier.isPrivate(method.getModifiers())) {
                        method.setAccessible(true);
                        Object obj = null;
                        try {
                            obj = method.invoke(book, null);
                        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                        System.out.println(method.getName()+" : "+ obj);
                    }
                }
            }

2. **private method with parameter**
-           package com.deepak;

            public class Book {
                private String bookName;
                private int length;
                private int width;
                private int pageArea() {
                    return length * width;
                }
                private String getBookName() {
                    return bookName;
                }
                private String showBookDetail(int len, int width, String bookName) {
                    this.bookName = bookName;
                    this.length = len;
                    this.width = width;
                    return "The Book having the name: " + getBookName() + " with " + pageArea()+ " pages";
                }	
            } 

            package com.deepak;

            import java.lang.reflect.InvocationTargetException;
            import java.lang.reflect.Method;
            import java.lang.reflect.Modifier;

            public class PrivateMethodDemo {

                public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException,
                        InvocationTargetException, NoSuchFieldException, SecurityException, NoSuchMethodException {
                    
                    Book book = new Book();
                    PrivateMethodDemo obj = new PrivateMethodDemo();
                    
                    //print private method return value by method name
                    obj.printMethodValue(book, "showBookDetail", 120 ,23, "Master in Reflection");
                }
                
                //Access private method by using method name for parameterized method.
                private void printMethodValue(Book book, String methodName, int len, int width, String bookName) throws NoSuchMethodException, SecurityException {
                    Method method = Book.class.getDeclaredMethod(methodName, new Class[]{int.class, int.class, String.class});	
                    if(Modifier.isPrivate(method.getModifiers())) {
                        method.setAccessible(true);
                        Object obj = null;
                        try {
                            obj = method.invoke(book, new Object[] {len,width,bookName});
                        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                        System.out.println(method.getName()+" : "+ obj);
                    }
                }
            }

## Access Private Fields using Reflection API
- Reflection API can access a private field by calling setAccessible(true) on its Field instance.
- **Class.getDeclaredFields()**: It returns an array of Field of a class that can be public, protected, private fields but it excludes inherited fields.
- **Field**: It provides information about a class field.
- **Modifier**: It decodes class and member access modifiers using its static methods.
- **Modifier.isPrivate()**: It checks if the filed, method or constructor are private using its modifiers.
- **field.setAccessible(boolean)**: When we pass true, it allows to access private field.
-           package com.deepak;

            public class Book {
                private String bookName;
                private int length;
                private int width;

                public Book(String bookName, int length, int width) {
                    this.bookName = bookName;
                    this.length = length;
                    this.width = width;
                }
                
                private int pageArea() {
                    return length * width;
                }
                private String getBookName() {
                    return bookName;
                }
                private String showBookDetail(int len, int width, String bookName) {
                    this.bookName = bookName;
                    this.length = len;
                    this.width = width;
                    return "The Book having the name: " + getBookName() + " with " + pageArea()+ " pages";
                }	
            } 

            package com.deepak;

            import java.lang.reflect.Field;
            import java.lang.reflect.InvocationTargetException;
            import java.lang.reflect.Modifier;

            public class PrivateFieldDemo {

                public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException,
                        InvocationTargetException, NoSuchFieldException, SecurityException, NoSuchMethodException {
                    
                    Book book = new Book("Core Java", 12, 5);
                    PrivateFieldDemo ob = new PrivateFieldDemo();
                    
                    //print all private fields and their value
                    ob.printAllPrivateFields(book);
                    System.out.println("-----------------------");
                    
                    //print private field value by field name
                    ob.printFieldValue(book, "bookName");
                }

                private void printAllPrivateFields(Book book) throws IllegalArgumentException, IllegalAccessException {
                    Field[] fieldList = Book.class.getDeclaredFields();
                    for(Field field: fieldList) {
                        if(Modifier.isPrivate(field.getModifiers())) {
                            field.setAccessible(true);
                            System.out.println(field.getName()+" : "+field.get(book));
                        }
                    }
                }

                private void printFieldValue(Book book, String fieldName) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
                    Field field = Book.class.getDeclaredField(fieldName);
                    if(Modifier.isPrivate(field.getModifiers())) {
                        field.setAccessible(true);
                        System.out.println(field.getName()+" : "+field.get(book));
                    }
                }
            }

## Instantiate a Class by Accessing Private Constructor using Reflection API
- Reflection API can make accessible its private constructor by **calling setAccessible(true)** on its Constructor instance and **using newInstance() we can instantiate the class**.
- Here we will show two ways to instantiate a class accessing private constructor using Reflection API.
    1. **Find the private constructor for given number of arguments and types and instantiate the class**.
    2. **Find the private constructor using given constructor name and instantiate the class**.
- **Class.getDeclaredConstructors()**: It returns an array of Constructor of a class that can be public, protected or private constructor.
- **Constructor**: It gives the information of a class constructor.
- **constructor.setAccessible()**: When it is set true, it allows to access private constructor.
- **constructor.newInstance()**: The class is instantiated by using the calling constructor. We need to pass required parameters.
-           package com.deepak;

            public class Car {
                private Integer carId;
                private String carName;
                private Car(){}
                private Car(Integer carId, String carName) {
                    this.carId = carId;
                    this.carName = carName;
                }
                public Integer getCarId() {
                    return carId;
                }
                public String getCarName() {
                    return carName;
                }
            }

            package com.deepak;

            import java.lang.reflect.Constructor;
            import java.lang.reflect.InvocationTargetException;
            import java.lang.reflect.Modifier;

            public class PrivateConstructorDemo {
                public static void main(String[] args) throws InstantiationException, IllegalAccessException,
                        IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

                    PrivateConstructorDemo ob = new PrivateConstructorDemo();
                    ob.craeteObject(10, "Alto");
                    System.out.println("-------------------------");
                    ob.craeteObjectByConstructorName(20, "Santro");
                }

                //Find the private constructor for given number of arguments and types and instantiate the class. 
                private void craeteObject(int carId, String carName) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    Constructor<?>[] constructorlist = Car.class.getDeclaredConstructors();
                    for(Constructor<?> constructor: constructorlist) {
                        if(Modifier.isPrivate(constructor.getModifiers())) {
                            constructor.setAccessible(true);
                            Class<?>[] constructorparameterTypeList = constructor.getParameterTypes();
                            if(constructor.getParameterCount() == 2 && constructorparameterTypeList[0] == Integer.class && constructorparameterTypeList[1]  == String.class) {
                                Car carObj = (Car)constructor.newInstance(new Object[] {carId, carName});
                                System.out.println("Car Id:"+ carObj.getCarId());
                                System.out.println("Car Name:"+ carObj.getCarName());
                            }				
                        }
                    }
                }

                //Find the private constructor using given constructor name and instantiate the class.
                private void craeteObjectByConstructorName(int carId, String carName) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    Constructor<Car> constructor = Car.class.getDeclaredConstructor(new Class[] {Integer.class, String.class});
                    if(Modifier.isPrivate(constructor.getModifiers())) {
                        constructor.setAccessible(true);
                        Car carObj = (Car)constructor.newInstance(new Object[] {carId, carName});
                        System.out.println("Car Id:"+ carObj.getCarId());
                        System.out.println("Car Name:"+ carObj.getCarName());
                    }
                }
            }



## Summary:
1. Reflection programming in java **helps in retrieving and modifying information about Classes** and **Class members such variable, methods, constructors**.
2. Reflection API in Java can be implemented using classes in **java.lang.reflect** package and methods of **java.lang.Class** class.
3. Some **commonly used methods of java.lang.Class** class are 
    - **getName()**
    - **getSuperclass()**
    - **getInterfaces()**
    - **getModifiers()**.
    - **getConstructors()**
    - **getDeclaredMethods()**
    - **getFields()**
4. Some **commonly used classes in java.lang.reflect** package are 
    - **Field**
    - **Method**
    - **Constructor**
    - **Modifier**.
5. Reflection API **can access private methods and variables** of a class which could be a security threat.
6. Reflection API is a powerful capability provided by Java, but it comes with some 
    - **overheads such as slower performance**
    - **security vulnerability**
    - **permission issue**.
