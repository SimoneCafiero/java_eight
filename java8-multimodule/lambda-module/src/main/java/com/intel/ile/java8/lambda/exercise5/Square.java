package com.intel.ile.java8.lambda.exercise5;

public class Square implements RegularPolygon{

	private final int sideLength;
	
	public Square(int sideLength){
		this.sideLength = sideLength;
	}
	
	@Override
	public int getNumSides() {
		return 4;
	}

	@Override
	public int getSideLength() {
		return sideLength;
	}
}