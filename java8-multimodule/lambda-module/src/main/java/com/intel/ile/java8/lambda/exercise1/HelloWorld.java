package com.intel.ile.java8.lambda.exercise1;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class HelloWorld {

	private static final Logger logger = LogManager.getLogger(HelloWorld.class);
	
	public static void main(String ... args){
		logger.info("Hello World!");
	}	
}