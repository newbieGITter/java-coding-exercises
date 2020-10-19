package com.example.udemy50coding;

public class Problem6FindingMaximumSubarray {

	public static void main(String[] args) {
		int[] A = { -2, 9, -2, 3, -2, 1, 3, -1 };
		System.out.println("bruteForceSolution: " + bruteForceSolution(A));
		System.out.println("usingKadaneAlgorithm: " + usingKadaneAlgorithm(A));
	}
	
	// Time complexity: O(n)
	// Space complexity: O(1)
	private static int usingKadaneAlgorithm(int[] a) {
		int globalSum = Integer.MIN_VALUE;
		int localSum = 0;

		for (int element : a) {
			localSum = Math.max(element, localSum + element);
			globalSum = Math.max(globalSum, localSum);
		}

		return globalSum;
	} 

	// Time complexity: O(n²)
	// Space complexity: O(1)
	private static int bruteForceSolution(int[] a) {
		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < a.length; i++) {
			int cumulativeSum = 0;

			for (int j = i; j < a.length; j++) {
				cumulativeSum += a[j];
				maxSum = Math.max(maxSum, cumulativeSum);
			}
		}
		return maxSum;
	}
}
