package com.example.udemy50coding;

import java.util.Arrays;

public class Problem21ProductsOfArrayExceptSelf {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 2 };

		System.out.print("Using Brute force solution:");
		Arrays.stream(findProductExceptSelf(arr)).forEach(s -> System.out.print(s + " "));
		System.out.println();
		System.out.print("Using dynamic programming:");
		Arrays.stream(findProductExceptSelf_dynamicProgramming(arr)).forEach(s -> System.out.print(s + " "));
	}

	// Brute force solution:
	// Time complexity: O(n²)
	// Space complexity: O(n)
	private static int[] findProductExceptSelf(int[] arr) {
		int n = arr.length;
		int[] output = new int[n];

		for (int i = 0; i < n; i++) {
			int product = 1;

			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				} else {
					product = product * arr[j];
				}
			}
			output[i] = product;
		}
		return output;
	}
	
	// Using dynamic programming
	// Time complexity: O(n)
	// Space complexity: O(n)
	private static int[] findProductExceptSelf_dynamicProgramming(int[] arr) {
		int n = arr.length;
		int[] cumulativeFromLeft = new int[n];
		cumulativeFromLeft[0] = 1;
		
		for(int i = 1; i < n; i++) {
			cumulativeFromLeft[i] = cumulativeFromLeft[i-1] * arr[i-1];
		}
		
		int[] cumulativeFromRight = new int[n];
		cumulativeFromRight[n-1] = 1;
		
		for(int i = n-2; i >= 0; i--) {
			cumulativeFromRight[i] = cumulativeFromRight[i+1] * arr[i+1];
		}
		
		int[] output = new int[n];
		for(int i = 0; i < n; i++) {
			output[i] = cumulativeFromLeft[i] * cumulativeFromRight[i];
		}
		
		return output;
	}
}
