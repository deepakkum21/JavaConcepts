# Annotation

## What?
- An annotation is a **kind of meta data** in java which can be applied at various elements of java sourcecode so that later some tool, debugger or application program can take advantage of these annotations.
- we **can annotate classes, methods, variables, parameters and packages** in java OR in one word almost everything.

### What is this metadata in java language context? Why we even care about them? Let’s understand the need to metadata with an example.
        public final class MyFinalClass{
            //other class members
        }
- ‘final’ keyword in class declaration. And the impact of this declaration is that you can’t extend this class or make a child class of it. How compiler understand this? Simply because of ‘final‘ keyword.
- A metadata is **data about data**. Metadata **adds some additional flags on your actual data** (i.e. in above case the class MyFinalClass), and **in runtime either you or JVM who understand these flags, can utilize this metadata information to make appropriate decisions based on context**.
- we use the **annotations to denote metadata**. We **can annotate classes, interface, methods, parameters and even packages also**. We have to utilize the metadata information represented by these annotations in runtime usually.


## Annotations Applied To Other Annotations
1. five annotations are **used inside other annotations to hint compiler that how new annotation should be treated by JVM**. 
2. Following are the annotations which are applied to other annotation
    - `@Retention`
    - `@Documented`
    - `@Target`
    - `@Inherited`
    - `@Repeatable`

### 1. @Retention
- **specifies how the marked annotation is stored in java runtime.**
- **Whether** it is **limited to source code only**, **embedded into the generated class file**, or it will be **available at runtime through reflection as well**.
- Has 3 Retention policy
    - Source
    - class (deafult)
    - runtime
    -       package com.deepak;

            import java.lang.annotation.Retention;
            import java.lang.annotation.RetentionPolicy;

            // @Retention(RetentionPolicy.SOURCE)                       // annotations are to be discarded by the compiler
            // @Retention(RetentionPolicy.CLASS) 						// Annotations are to be recorded in the class file by the compiler but need not be                                                                   // retained by the VM at run time.  This is the default behavior
            @Retention(RetentionPolicy.RUNTIME)							// Annotations are to be recorded in the class file by the compiler and retained by the                                                               // VM at run time, so they may be read reflectively			
            public @interface MyCustomAnnotation {
                //some code
            }

### 2. @Target
- **restrict the usage of new annotation on certain java elements** such as class, interface or methods.
- After specifying the targets, you will be **able to use the new annotation on given elements only**.
-           import java.lang.annotation.ElementType;
            import java.lang.annotation.Target;
            
            @Target(value = {ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, 
                            ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.LOCAL_VARIABLE, 
                            ElementType.PACKAGE, ElementType.PARAMETER})
            public @interface MyCustomAnnotation {
                //Some other code
            }

### 3. @Inherited
- When you apply **this annotation to any other annotation i.e. @MyCustomAnnotation; and @MyCustomAnnotation is applied of any class MyParentClass then @MyCustomAnnotation will be available to all child classes of MyParentClass as well**. 
-  essentially means that when you try to lookup the annotation @MyCustomAnnotation on any class X, then all the parent classes of X upto n level are queried for @MyCustomAnnotation; and if annotation is present at any level then result is true, else false.
- note that by **default annotations applied on parent class are not available to child classes**.
-           import java.lang.annotation.Inherited;
            
            @Inherited
            public @interface MyCustomAnnotation {
                //Some other code
            }

### 4. @Documented
- This annotation **indicates that new annotation should be included into java documents generated by java document generator** tools.
-           import java.lang.annotation.Documented;
            
            @Documented
            public @interface MyCustomAnnotation {
                //Some other code
            } 

### 5. @Repeatable        
- By default, an **annotation is applied on a java element only once**. 
- But, by any requirement, you have to **apply a annotation more than once, then use @Repeatable annotation** on your new annotation.
- @Repeatable has been **added in latest java 8** release.               
-           package com.deepak;

            //Importing required packages for repeating annotation   
            import java.lang.annotation.Repeatable;
            import java.lang.annotation.Retention;
            import java.lang.annotation.RetentionPolicy;

            //Declaring repeatable annotation type  
            @Repeatable(Students.class)
            @interface Student {
                String name();

                String percentage();
            }

            //Declaring container for repeatable annotation type  
            @Retention(RetentionPolicy.RUNTIME)
            @interface Students {
                Student[] value();
            }

            //Repeating annotation  
            @Student(name = "Akhil", percentage = "87")
            @Student(name = "David", percentage = "78")
            @Student(name = "Smith", percentage = "98")
            public class MyCustomAnnotation {
                public static void main(String[] args) {
                    // Getting annotation by type into an array
                    Student[] Students = MyCustomAnnotation.class.getAnnotationsByType(Student.class);
                    for (Student student : Students) { // Iterating values
                        System.out.println(student.name() + " with " + student.percentage() + "%");
                    }
                }
            }

## Types of Annotation
- `Marker Annotation`
- `Single-Value Annotation`
- `Multi-Value Annotation`
1. `Marker Annotation`
    - An annotation that **has no method**, is called marker annotation. For example:

        @interface MyAnnotation{ }  
    - The **@Override and @Deprecated are marker annotations**.

2. `Single-Value Annotation`
    - An annotation that **has one method**, is called single-value annotation. For example:

        @interface MyAnnotation{  
            int value();  
        }  
    - We can provide the default value also. For example:

        @interface MyAnnotation{  
            int value() default 0;  
        }  
    - How to apply Single-Value Annotation
        Let's see the code to apply the single value annotation.

        @MyAnnotation(value=10)   
        The value can be anything.

3. `Multi-Value Annotation`
    - An annotation that **has more than one method**, is called Multi-Value annotation. For example:

        @interface MyAnnotation{  
            int value1();  
            String value2();  
            String value3();  
        }  
        
    - We can provide the default value also. For example:

        @interface MyAnnotation{  
            int value1() default 1;  
            String value2() default "";  
            String value3() default "xyz";  
        }  
    - How to apply Multi-Value Annotation
    Let's see the code to apply the multi-value annotation.

    `@MyAnnotation(value1=10,value2="Arun Kumar",value3="Ghaziabad") `

## Built-In Annotations 
- `@Override`
- `@SuppressWarnings`
- `@Deprecated`
- `@SafeVarargs`
- `@FunctionalInterface`
### 1. @Override
- **checks that the annotated method is overridden method**.
- It causes a compile time “error” if the annotated method is not found in one of the parent classes or implemented interfaces.
-           public class DemoClass {
                //some code
                    
                @Override
                public String toString() {
                    return super.toString();
                }
                    
                @Override
                public int hashCode() {
                    return super.hashCode();
                }
            }

### 2. @Deprecated
- Use this annotation on **methods or classes which you need to mark as deprecated**. 
- Any **class that will try to use this deprecated class or method, will get a compiler “warning“**.      
-           @Deprecated
            public Integer myMethod() {
                return null;
            }      

### 3. @SuppressWarnings
- This annotation **instructs the compiler to suppress the compile time warnings specified** in the annotation parameters. e.g. to ignore the warnings of unused class attributes and methods use @SuppressWarnings("unused") **either for a given attribute or at class level for all the unused attributes and unused methods**.
-           @SuppressWarnings("unused")
            public class DemoClass {
                //@SuppressWarnings("unused")
                private String str = null;     
                
                //@SuppressWarnings("unused")
                private String getString() {
                    return this.str;
                }
            }

### 4. @SafeVarargs (1.7)
- annotation **ensures that the body of the annotated method or constructor** does not perform potentially unsafe operations on its varargs parameter. Applying this annotation to a method or constructor suppresses unchecked warnings about a non-reifiable variable arity (vararg) type and suppresses unchecked warnings about parameterized array creation at call sites.
-           public static <T> List<T> list( final T... items ) {
                return Arrays.asList( items );
            }

### 5. @FunctionalInterface
- This annotation is used to **mark an interface as functional interface which are introduced in java 8**. 
-           @FunctionalInterface
            public interface MyFirstFunctionalInterface {
                public void doSomeWork();
            }              

## Creating Custom Annotations
To create a custom annotation, you must **use the keyword “@interface“**. Other important things to remember while creating custom annotations are listed below:
- Each **method declaration defines an element of the annotation** type.
- **Method declarations must not have any parameters or a throws clause**.
- **Return types are restricted to primitives**, String, Class, enums, annotations, and arrays of the preceding types.
- **Methods can have default values**. 

## Processing Annotations Using Reflection

            package com.deepak;

            import java.lang.annotation.Annotation;
            import java.lang.annotation.ElementType;
            import java.lang.annotation.Retention;
            import java.lang.annotation.RetentionPolicy;
            import java.lang.annotation.Target;
            import java.lang.reflect.AnnotatedElement;
            import java.lang.reflect.Method;

            @Target({ ElementType.TYPE, ElementType.METHOD })
            @Retention(RetentionPolicy.RUNTIME)
            @interface JavaFileInfo {
                String author() default "unknown";

                String version() default "0.0";
            }

            @JavaFileInfo(author = "Deepak", version = "1.0")
            class DemoClass {
                @JavaFileInfo(author = "Lokesh", version = "1.0")
                public String getString() {
                    return null;
                }
            }

            public class MyCustomAnnotation {
                public static void main(String[] args) throws NoSuchMethodException, SecurityException {
                    new DemoClass();
                    Class<DemoClass> demoClassObj = DemoClass.class;
                    readAnnotationOn(demoClassObj);
                    Method method = demoClassObj.getMethod("getString", new Class[] {});
                    readAnnotationOn(method);
                }

                static void readAnnotationOn(AnnotatedElement element) {
                    try {
                        System.out.println("\n Finding annotations on " + element.getClass().getName());
                        Annotation[] annotations = element.getAnnotations();
                        for (Annotation annotation : annotations) {
                            if (annotation instanceof JavaFileInfo) {
                                JavaFileInfo fileInfo = (JavaFileInfo) annotation;
                                System.out.println("Author :" + fileInfo.author());
                                System.out.println("Version :" + fileInfo.version());
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }