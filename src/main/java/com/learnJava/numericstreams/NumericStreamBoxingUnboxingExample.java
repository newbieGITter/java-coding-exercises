package com.learnJava.numericstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamBoxingUnboxingExample {

	public static List<Integer> boxing_2() {
		return IntStream.rangeClosed(1, 50).boxed().collect(Collectors.toList());
	}

	public static List<Integer> boxing() {
		return IntStream.rangeClosed(1, 25).boxed() // Stream<Integer>
				// all the elements will be passed one by one to get to the result as the
				// collection.
				.collect(Collectors.toList());

	}
	
	private static int unBoxing_2(List<Integer> integers) {
		return integers.stream().mapToInt(Integer::intValue).sum();
	}

	public static int unBoxing(List<Integer> integerList) {
		int sum = integerList.stream().mapToInt(Integer::intValue).sum();
		return sum;
	}

	public static void main(String[] args) {

		System.out.println("Converting PrimitiveStream to List : " + boxing_2());

		List<Integer> integers = boxing_2();

		System.out.println("Sum using Unboxing : " + unBoxing_2(integers));

	}
}
