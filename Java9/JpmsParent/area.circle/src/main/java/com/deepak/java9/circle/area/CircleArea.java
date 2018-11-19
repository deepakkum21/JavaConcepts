package com.deepak.java9.circle.area;

import java.util.function.DoubleFunction;

public class CircleArea {
	
	public double area(double radius) {
		DoubleFunction<Double> circleArea = (radii) ->  Math.PI * radii * radii ;
		return circleArea.apply(radius);
	}

}
