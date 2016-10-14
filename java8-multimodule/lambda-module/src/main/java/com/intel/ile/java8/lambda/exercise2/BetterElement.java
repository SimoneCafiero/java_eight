package com.intel.ile.java8.lambda.exercise2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BetterElement {

	private static final Logger logger = LogManager.getLogger(BetterElement.class);
	
	public static void main(String ... args) {
		String s1 = "first";
		String s2 = "second";
		
		char c1 = 'a';
		char c2 = 'b';
		
		logger.info(BetterElement.betterElement(s1, s2, (string1, string2) -> string1.length() > string2.length()));
		logger.info(BetterElement.betterElement(s1, s2, (string1, string2) -> true));
		logger.info(BetterElement.betterElement(c1, c2, (char1, char2) -> (char1.compareTo(char2)) != 1));
	}
	
	public static <T> T betterElement(T e1, T e2, TwoElementPredicate<T> predicate){
		return (predicate.isbetter(e1, e2)) ? e1 : e2;
	}
}