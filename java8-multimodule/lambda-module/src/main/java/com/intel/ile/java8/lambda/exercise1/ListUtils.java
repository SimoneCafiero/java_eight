package com.intel.ile.java8.lambda.exercise1;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ListUtils {

	public static void main(String ... args){
		String[] empty = {};
		String[] strings = {"a", "b", "c"};
		List<String> listOfStrings = Arrays.asList(strings);
		System.out.println(lastEntry(empty));
		System.out.println(lastEntry(strings));
		System.out.println(lastEntry(listOfStrings));
	}
	
	public static <T> Optional<T> lastEntry(List<T> entries){
		Objects.requireNonNull(entries);
		Optional<T> lastEntry = entries.isEmpty() ? Optional.empty() : Optional.of(entries.get(entries.size() - 1));
		return lastEntry;
	}
	
	public static <T> Optional<T> lastEntry(T[] entries){
		Objects.requireNonNull(entries);
		Optional<T> lastEntry = entries.length == 0 ? Optional.empty() : Optional.of(entries[entries.length - 1]);
		return lastEntry;
	}
}