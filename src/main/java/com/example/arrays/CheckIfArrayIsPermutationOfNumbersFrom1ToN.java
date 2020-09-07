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

		if (checkForPermutations_usingTwoSets(arr)) {
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

	private static boolean checkForPermutations_usingTwoSets(int[] A) {
		Set<Integer> testedSet = new HashSet<>();
		Set<Integer> perfectSet = new HashSet<>();

		for (int i = 0; i < A.length; i++) {
			testedSet.add(A[i]);
			perfectSet.add(i + 1);
		}
		int result = 1;
		for (int current : perfectSet) {
			// as soon as find 1 element missing return false
			if (!testedSet.contains(current))
				result = 0;
		}
		return result == 1 ? Boolean.TRUE : Boolean.FALSE;
	}

}
