package com.intel.ile.java8.lambda.exercise1;

import java.util.Arrays;
import java.util.Comparator;

public class Sorting {

	public static void main(String ... args){
		String[] words = {"cat", "elm", "book", "parrot", "sofa", "dog", "apple"};
		
		String[] shortestFirst = Sorting.sort(words, new Comparator<String>(){

			@Override
			public int compare(String arg0, String arg1) {
				return arg0.length() - arg1.length();
			}
		});
		System.out.println(Arrays.toString(shortestFirst));
		
		String[] longestFirst = Sorting.sort(words, new Comparator<String>(){
			@Override
			public int compare(String arg0, String arg1) {
				return arg1.length() - arg0.length();
			}
		});
		System.out.println(Arrays.toString(longestFirst));
		
		String[] alphabetFirst = Sorting.sort(words, new Comparator<String>(){
			@Override
			public int compare(String arg0, String arg1) {
				return arg0.charAt(0) - arg1.charAt(0);
			}
		});
		System.out.println(Arrays.toString(alphabetFirst));
		
		String[] eFirst = Sorting.sort(words, new Comparator<String>(){
			@Override
			public int compare(String arg0, String arg1) {
				if(arg0.contains("e") && !arg1.contains("e"))
					return -1;
				if(!arg0.contains("e") && arg1.contains("e"))
					return +1;
				return 0;
			}
		});
		System.out.println(Arrays.toString(eFirst));
		
	}
	
	public static <T> T[] sort(T[] array, Comparator<T> comparator){
		Arrays.sort(array, comparator);
		return array;
	}
}