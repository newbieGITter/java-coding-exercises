package com.example.udemy50coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Given an array of integers arr and an integer k, create a boolean function
// that checks if there exist two elements in arr such that we get k when we add
// them together.
public class Problem1PairThatSumsUptoK {
	
	// Input: arr = [4, 5, 1, -3, 6], k = -2
	// Output: true
	// Explanation: 1 + (-3) is equal to -2
	public static void main(String[] args) {
		int[] A = new int[] { 3, 1, 2, 4, 3 };
		int k = 7;
		bruteForcesolution(A, k);
		usingSortingAndPointerSolution(A, k);
		usingMap(A, k);
	}

	// Time complexity: O(n²)
	// Space complexity: O(1)
	private static boolean bruteForcesolution(int[] a, int k) {
		System.out.println("============bruteForcesolution=================");
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] + a[j] == k) {
					System.out.println("Two numbers which sum upto k are: " + a[i] + ", " + a[j]);
					return true;
				}
			}
		}
		System.out.println("No two numbers sum upto k");
		System.out.println("=============================");
		return false;
	}

	// Time complexity: O(nlogn)
	// Space complexity: O(1) if you are allowed to modify the input, O(n) else
	private static boolean usingSortingAndPointerSolution(int[] a, int k) {
		System.out.println("==========usingSortingAndPointerSolution===================");
		Arrays.sort(a);

		int left = 0, right = a.length - 1;
		while (left < right) {
			if (a[left] + a[right] == k) {
				System.out.println("Two numbers which sum upto k are: " + a[left] + ", " + a[right]);
				return true;
			} else if (a[left] + a[right] < k) {
				left++;
			} else {
				right--;
			}
		}
		System.out.println("No two numbers sum upto k");
		System.out.println("=============================");
		return false;
	}

	// Time complexity: O(n)
	// Space complexity: O(n)
	private static boolean usingMap(int[] a, int k) {
		Map<Integer, Boolean> visited = new HashMap<>();

		for (int element : a) {
			if (visited.containsKey(k - element)) {
				System.out.println("Two numbers which sum upto k are: " + element + ", " + (k - element));
				return true;
			} else {
				visited.put(element, true);
			}
		}
		System.out.println("No two numbers sum upto k");
		System.out.println("=============================");
		return false;
	}

}
