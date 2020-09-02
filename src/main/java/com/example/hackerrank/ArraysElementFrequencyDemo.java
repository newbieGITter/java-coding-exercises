package com.example.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class ArraysElementFrequencyDemo {

	public static void main(String[] args) {
		int arr[] = { 10, 20, 20, 10, 10, 20, 5, 20 };
		countFreq(arr);
	}

	static void countFreq(int arr[]) {
		Map<Integer, Integer> numMap = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			if (numMap.containsKey(arr[i])) {
				numMap.put(arr[i], numMap.get(arr[i]) + 1);
			} else {
				numMap.put(arr[i], 1);
			}
		}

		numMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.forEach(n -> System.out.println(n.getKey() + " " + n.getValue()));
	}

}
