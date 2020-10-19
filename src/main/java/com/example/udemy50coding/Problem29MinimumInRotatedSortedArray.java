package com.example.udemy50coding;

import java.util.Arrays;

public class Problem29MinimumInRotatedSortedArray {

	public static void main(String[] args) {
		int[] arr = { 10, 11, 4, 5, 6, 7, 8, 9 };

		System.out.println("Minimum nr in array using streams: " + Arrays.stream(arr).asLongStream().min().getAsLong());
		System.out.println("Minimum nr in array is:" + findMinimum_BruteForceSolution(arr));
		System.out.println("Minimum nr in array is:" + findMinimum_divideAndConquer(arr));
	}

	// Time complexity: O(n)
	// Space complexity: O(1)
	private static int findMinimum_BruteForceSolution(int[] arr) {
		int min = Integer.MAX_VALUE;

		for (int value : arr)
			min = Math.min(min, value);
		return min;
	}

	// By using divide and conquer (iteratively):
	// Time complexity: O(logn)
	// Space complexity: O(1)
	private static int findMinimum_divideAndConquer(int[] arr) {
		int left = 0;
		int right = arr.length - 1;

		if (arr[right] > arr[left]) {
			return arr[left];
		}

		while (left < right) {
			int mid = (left + right) / 2;

			if (arr[mid + 1] < arr[mid]) {
				return arr[mid + 1];
			} else if (arr[mid] < arr[mid - 1]) {
				return arr[mid];
			} else if (arr[mid] > arr[right]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return arr[left];
	}
}
