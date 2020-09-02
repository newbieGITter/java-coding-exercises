package com.example.arrays;

import java.util.HashSet;
import java.util.Set;

public class CheckIfArrayIsPermutationOfNumbersFrom1ToN {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 5, 3, 4, 7, 6 };
		int n = arr.length;

		if (checkForPermutations(arr, n)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	private static boolean checkForPermutations(int[] arr, int n) {
		Set<Integer> uniqueValues = new HashSet<>();
		int maxElement = 0;

		for (int i = 0; i < n; i++) {
			uniqueValues.add(arr[i]);

			maxElement = Math.max(maxElement, arr[i]);
		}

		if (maxElement != n) {
			return false;
		}
		if (uniqueValues.size() == n) {
			return true;
		}
		return false;
	}

}
