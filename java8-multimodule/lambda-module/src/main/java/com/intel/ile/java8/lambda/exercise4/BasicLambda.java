package com.intel.ile.java8.lambda.exercise4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasicLambda {

	private static final Logger logger = LogManager.getLogger(BasicLambda.class);

	public static void main(String ... args){
		List<String> words = Arrays.asList("first", "second", "third", "fourth", "bye");
		List<String> shortWords = BasicLambda.allMatches(words, s -> s.length() < 4);
		List<String> wordsWithB = BasicLambda.allMatches(words, s -> s.contains("b"));
		List<String> evenLengthWords = BasicLambda.allMatches(words, s -> (s.length() % 2) == 0);
		logger.info(shortWords);
		logger.info(wordsWithB);
		logger.info(evenLengthWords);

		List<Integer> nums = Arrays.asList(1, 10, 100, 1000, 10000);
		List<Integer> bigNums = BasicLambda.allMatches(nums, n -> n > 500);
		logger.info(bigNums);

		List<String> excitingWords = BasicLambda.transformedList(words, s -> s + "!");
		List<String> eyeWords = BasicLambda.transformedList(words, s -> s.replace("i", "eye"));
		List<String> upperCaseWords = BasicLambda.transformedList(words, String::toUpperCase);
		List<Integer> wordLengths = BasicLambda.transformedList(words, String::length);

		logger.info(excitingWords);
		logger.info(eyeWords);
		logger.info(upperCaseWords);
		logger.info(wordLengths);

		logger.info(BasicLambda.blackJack(19, 22));
		logger.info(BasicLambda.blackJack(22, 21));
		logger.info(BasicLambda.blackJack(22, 22));
	}

	public static <T> List<T> allMatches(List<T> list, Predicate<T> predicate){
		List<T> result = new LinkedList<>(); 
		for(T element: list){
			if(predicate.test(element)){
				result.add(element);
			}
		}
		return result;
	}

	public static <T, E> List<E> transformedList(List<T> list, Function<T, E> function){
		List<E> result = new LinkedList<>(); 
		for(T element: list){
			result.add(function.apply(element));
		}
		return result;
	}

	public static int blackJack(int a, int b){
		if(a >= 22 && b >= 22) return 0;
		int minA = (a >= 22)? 0 : Math.min(a, 21);
		int minB = (b >= 22)? 0 : Math.min(b, 21);
		return Math.max(minA, minB);
	}
}