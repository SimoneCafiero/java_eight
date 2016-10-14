package com.intel.ile.java8.lambda.exercise3;

import java.util.Arrays;
import java.util.Comparator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasicLambda {

	private static final Logger logger = LogManager.getLogger(BasicLambda.class);
	
	public static void main(String ... args){
		String[] words = {"first", "second", "third", "fourth", "bye"};
		String[] shortestToLongest = BasicLambda.sort(words, BasicLambda::shortestToLongest);
		String[] longestToShortest = BasicLambda.sort(words, BasicLambda::longestToShortest);
		String[] alphabetically = BasicLambda.sort(words, BasicLambda::alphabetically);
		String[] eFirst = BasicLambda.sort(words, BasicLambda::findFirstE);
		
		logger.info(Arrays.toString(shortestToLongest));
		logger.info(Arrays.toString(longestToShortest));
		logger.info(Arrays.toString(alphabetically));
		logger.info(Arrays.toString(eFirst));
	}
	
	public static int shortestToLongest(String word1, String word2){
		return word1.length() - word2.length();
	}
	
	public static int longestToShortest(String word1, String word2){
		return word2.length() - word1.length();
	}
	
	public static int alphabetically(String word1, String word2){
		return word1.charAt(0) - word2.charAt(0);
	}
	
	private static int findFirstE(String word1, String word2) {
		int e1 = word1.indexOf("e");
		int e2 = word2.indexOf("e");
		if(e1 > -1 && e2 > -1) return e1 - e2;
		if(e1 < 0 && e2 > -1) return +1;
		if(e1 > -1 && e2 < 0) return -1;
		return 0;
	}

	public static <T> T[] sort(T[] array, Comparator<T> comparator){
		T[] backup = Arrays.copyOf(array, array.length);
		Arrays.sort(backup, comparator);
		return backup;
	}	
}