package com.example.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindKthLargestElementsInArray {

	public static void main(String[] args) {
		int a[] = new int[] { 1, 2, 43, 12, 33, 46, 90, 2, 2, 3, 3, 5, 56, 19 };
		int k = 8;

		findKthLargestElement(a, k);
	}

	private static void findKthLargestElement(int[] a, int k) {
		List<Integer> kthLargestElements = new ArrayList<>();

		for (int i = 0; i < k; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				int temp = 0;

				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
			kthLargestElements.add(a[a.length - 1 - i]);
		}
		System.out.print("Largest 'k' numbers in the array are: ");
		kthLargestElements.stream().forEach(s -> System.out.print(s + " "));

		// Map<Integer, String> map = new HashMap<>();
		// map.put(1, "saa");
		// map.put(2, "champa");
		// map.keySet().stream().forEach(s -> System.out.print(map.get(s) + " "));
	}

}
