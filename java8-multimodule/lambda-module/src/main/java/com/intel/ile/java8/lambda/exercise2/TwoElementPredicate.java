package com.intel.ile.java8.lambda.exercise2;

@FunctionalInterface
public interface TwoElementPredicate <T> {

	boolean  isbetter(T e1, T s2);
}