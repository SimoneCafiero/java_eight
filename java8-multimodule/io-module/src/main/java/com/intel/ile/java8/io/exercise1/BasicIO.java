package com.intel.ile.java8.io.exercise1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasicIO {

	private static final Logger logger = LogManager.getLogger(BasicIO.class);
	
	public static void main(String ... args){
		String filepath = "src/main/resources/files/file_1.txt";
		String twitterFilepath = "src/main/resources/files/enable1-word-list.txt";
		String tweetsFilepath = "src/main/resources/files/tweets.txt";
		
		BasicIO.words(filepath);
		BasicIO.wordsContainingABC(filepath);
		BasicIO.longestNotContainingAE(filepath);
		BasicIO.shortestContainingQ(filepath);
		
		BasicIO.twitter(twitterFilepath);
		BasicIO.tweets(twitterFilepath, tweetsFilepath);
	}
	
	public static void words(String filepath){
		StreamProcessor.processFile(filepath, logger::info);
	}
	
	public static void wordsContainingABC(String filepath){
		StreamProcessor.processFile(filepath, BasicIO::logWordContainsABC);
	}
	
	public static void longestNotContainingAE(String filepath){
		StreamProcessor.processFile(filepath, BasicIO::logLongestWordNotContainingAE);
	}
	
	public static void shortestContainingQ(String filepath){
		StreamProcessor.processFile(filepath, BasicIO::logShortestWordContainingQ);
	}
	
	public static void twitter(String filepath){
		StreamProcessor.processFile(filepath, BasicIO::logTwitter);
	}
	
	public static void tweets(String filepath, String destination){
		StreamProcessor.processFile(filepath, lines -> BasicIO.writeTweets(destination, lines));
	}
	
	public static void logWordContainsABC(Stream<String> stream){
		String found = stream.map(String::toLowerCase)
							 .filter(word -> word.length() == 8)
				             .filter(word -> word.contains("a"))
				             .filter(word -> word.contains("b"))
				             .filter(word -> word.contains("c"))
				             .findFirst()
				             .orElse("No 8-letter word containing a, b, and c");
		logger.info(found);
	}
	
	public static void logLongestWordNotContainingAE(Stream<String> stream){
		String found = stream.map(String::toLowerCase)
				             .filter(word -> !word.contains("a"))
				             .filter(word -> !word.contains("e"))
				             .max((w1, w2) -> w1.length() - w2.length())
				             .orElse("No word without a and e");
		logger.info(found);
	}
	
	public static void logShortestWordContainingQ(Stream<String> stream){
		String found = stream.map(String::toLowerCase)
				             .filter(word -> word.contains("q"))
				             .min((w1, w2) -> w1.length() - w2.length())
				             .orElse("No word without q");
		logger.info(found);
	}
	
	public static void logTwitter(Stream<String> stream){
		Predicate<String> isCool = word -> word.contains("cool");
		Predicate<String> isWow = word -> word.contains("wow");
		List<String> words = stream.filter(isCool.or(isWow))
								   .map(String::toUpperCase)
								   .map(word -> word + "!")
								   .collect(Collectors.toList());
		logger.info(words);
	}
	
	public static void writeTweets(String destination, Stream<String> stream){
		try{
			Files.write(Paths.get(destination), stream.map(word -> word + "!!!").collect(Collectors.toList()));
		}catch (IOException e){
			logger.error("Exception executing the method.", e);
		}
	}
}