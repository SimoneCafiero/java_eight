package com.intel.ile.java8.lambda.exercise5;

public interface RegularPolygon {
	
	static int totalSides(RegularPolygon[] polygons){
		int sum = 0;
		for(RegularPolygon polygon: polygons){
			sum += polygon.getNumSides();
		}
		return sum;
	}
	
	default int getPerimeter(){
		return getNumSides() * getSideLength(); 
	}
	
	default double getInteriorAngle(){
		return Math.toRadians((getNumSides() - 2) * Math.PI / getNumSides()); 
	}
	
	int getNumSides();
	int getSideLength();
}