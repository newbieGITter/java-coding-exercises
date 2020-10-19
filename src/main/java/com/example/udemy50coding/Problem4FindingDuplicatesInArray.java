package com.example.udemy50coding;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Problem4FindingDuplicatesInArray {
	// Input: 4, 2, 1, 3, 2
	// Output: 2
	public static void main(String[] args) {
		int[] A = new int[] { 4, 2, 1, 3, 2, 1 };
		System.out.println("bruteForceSolution: " + bruteForceSolution(A));
		System.out.println("usingMap: " + usingMap(A));
		System.out.println("usingSorting: " + usingSorting(A));
	}

	// Time complexity: O(n)
	// Space complexity: O(n)
	private static int usingMap(int[] a) {
		Map<Integer, Boolean> visited = new LinkedHashMap<>();

		for (int num : a) {
			if (visited.containsKey(num)) {
				return num;
			} else {
				visited.put(num, true);
			}
		}
		return 0;
	}

	// Time complexity: O(nlogn)
	// Space complexity: O(1) if you are allowed to modify the input, O(n) else
	// Only use this if you do not want to search the one which appeared first in
	// the array
	private static int usingSorting(int[] a) {
		Arrays.sort(a);

		for (int i = 1; i < a.length; i++) {
			if (a[i] == a[i - 1]) {
				return a[i];
			}
		}
		return 0;
	}

	// Time complexity: O(n²)
	// Space complexity: O(1)
	private static int bruteForceSolution(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					return a[i];
				}
			}
		}
		return 0;
	}

}
