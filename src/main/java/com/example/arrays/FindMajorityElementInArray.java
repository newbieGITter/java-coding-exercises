package com.example.arrays;

import java.util.HashMap;
import java.util.Map;

public class FindMajorityElementInArray {

	public static void main(String[] args) {
		int a[] = new int[] { 2, 2, 2, 2, 5, 5, 2, 3, 3 };

		findMajority(a);
	}

	private static void findMajority(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				int count = map.get(arr[i]) + 1;
				if (count > arr.length / 2) {
					System.out.println("Majority element Found: " + arr[i] + ". It appeared " + count
							+ " times in the given array.");
					return;
				} else {
					map.put(arr[i], count);
				}

			} else {
				map.put(arr[i], 1);
			}
		}
		System.out.println("No majority element found.");
	}

}
