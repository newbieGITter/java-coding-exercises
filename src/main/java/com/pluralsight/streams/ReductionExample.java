package com.pluralsight.streams;

import java.util.Arrays;
import java.util.List;

public class ReductionExample {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(11, 22, 33);
		
		Integer result = list.stream().reduce(0, Integer::sum);
		//System.out.println("Result: " + result); // should return identity element when list is empty
		//System.out.println("Result: " + result); // should return single element when only one element exists in list
		System.out.println("Result: " + result); // should return sum of all elements when more than one element exists
	}
}
