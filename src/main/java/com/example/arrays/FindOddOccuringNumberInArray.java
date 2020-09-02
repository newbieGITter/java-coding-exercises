package com.example.arrays;

import java.util.HashMap;

public class FindOddOccuringNumberInArray {

	public static void main(String[] args) {
		int arr[] = new int[] { 2, 3, 5, 4, 5, 2, 4, 3, 2, 4, 2 };
		int n = arr.length;
		System.out.println(getOddOccurrence_1(arr, n));
		System.out.println(getOddOccurrence_2(arr, n));
		System.out.println(getOddOccurrence_3(arr, n));
	}

	// Bad approach as Time complexity of this solution is O(n2).
	private static int getOddOccurrence_1(int arr[], int arr_size) {
		int i;
		for (i = 0; i < arr_size; i++) {
			int count = 0;
			for (int j = 0; j < arr_size; j++) {
				if (arr[i] == arr[j])
					count++;
			}
			if (count % 2 != 0)
				return arr[i];
		}
		return -1;
	}

	// Better approach than above one. But needs extra space
	private static int getOddOccurrence_2(int arr[], int n) {
		HashMap<Integer, Integer> hmap = new HashMap<>();

		// Putting all elements into the HashMap
		for (int i = 0; i < n; i++) {
			if (hmap.containsKey(arr[i])) {
				int val = hmap.get(arr[i]);

				// If array element is already present then
				// increase the count of that element.
				hmap.put(arr[i], val + 1);
			} else

				// if array element is not present then put
				// element into the HashMap and initialize
				// the count to one.
				hmap.put(arr[i], 1);
		}

		// Checking for odd occurrence of each element present
		// in the HashMap
		for (Integer a : hmap.keySet()) {
			if (hmap.get(a) % 2 != 0)
				return a;
		}
		return -1;
	}

	// The Best Solution is to do bitwise XOR of all the elements. XOR of all elements gives us odd occurring element.
	// Please note that XOR of two elements is 0 if both elements are same and XOR of a number x with 0 is x.
	private static int getOddOccurrence_3(int ar[], int ar_size) {
		int i;
		int res = 0;
		for (i = 0; i < ar_size; i++) {
			res = res ^ ar[i];
		}
		return res == 0? -1: res; // If there are no odd occuring numbers, then we should return -1.
	}

}
