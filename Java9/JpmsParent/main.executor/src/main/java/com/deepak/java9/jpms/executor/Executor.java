package com.deepak.java9.jpms.executor;

import com.deepak.java9.circle.area.CircleArea;

public class Executor {
	
	public static void main(String ... args) {
		CircleArea circleArea =new CircleArea();
		System.out.println( circleArea.area(1000));
	}

}
