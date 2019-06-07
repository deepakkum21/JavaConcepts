package com.deepak.java8.functionalinterfaces;

interface Doable{  
    default void doIt(){  
        System.out.println("Do it now");  
    }  
}  
@FunctionalInterface  
interface Sayable2 extends Doable{  
    void say(String msg);   // abstract method  
}  
public class Example3 implements Sayable2{  
    public void say(String msg){  
        System.out.println(msg);  
    }  
    public static void main(String[] args) {  
        Example3 fie = new Example3();  
        fie.say("Hello Deepak!!!!");  
        fie.doIt();  
    }  
}
