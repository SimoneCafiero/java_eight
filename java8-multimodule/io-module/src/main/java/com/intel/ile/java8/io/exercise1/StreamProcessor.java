package com.intel.ile.java8.io.exercise1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@FunctionalInterface
public interface StreamProcessor {
	
	public static final Logger logger = LogManager.getLogger(StreamProcessor.class);
	
	void processStream(Stream<String> strings);
	
	public static void processFile(String filepath, StreamProcessor processor) {
		try(Stream<String> lines = Files.lines(Paths.get(filepath))) {
			processor.processStream(lines);
		} catch(IOException e) {
			logger.error("Exception while executing the method.", e);
		}
	}
}
