package com.learnJava.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsMaxMinExample_2 {
	
	private static Optional<Integer> findMaxvalue(List<Integer> integers) {
		return integers.stream().reduce((x,y) -> x > y ? x : y);
	}
	
	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(6, 7, 8, 9, 10);
		
		System.out.println(findMaxvalue(integers).get());
		
		System.out.println(findMinValue(integers).get());
	}

	private static Optional<Integer> findMinValue(List<Integer> integers) {
		return integers.stream().reduce((x, y) -> x < y? x: y);
	}

}
