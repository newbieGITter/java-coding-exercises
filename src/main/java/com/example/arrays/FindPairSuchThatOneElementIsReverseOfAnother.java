package com.example.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindPairSuchThatOneElementIsReverseOfAnother {

	public static void main(String[] args) {
		int a[] = { 16, 12, 66, 456, 23, 21, 691, 25 };
		countReverse(a, a.length);
	}

	private static void countReverse(int[] a, int n) {
		int count = 0;
		List<String> indexes = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (reverse(a[i]) == a[j]) {
					count++;
					indexes.add(i + ":" + j);
				}
			}
		}
		System.out.println("Count is: " + count);
		indexes.stream().forEach(str -> {
			System.out.println("Pairs of element found at below indexes: ");
			System.out.println("(" + str.split(":")[0] + ", " + str.split(":")[1] + ")");
		});
	}

	private static int reverse(int num) {
		int rev_num = 0;

		// Loop to iterate till the number is
		// greater than 0
		while (num > 0) {

			// Extract the last digit and keep
			// multiplying it by 10 to get the
			// reverse of the number
			rev_num = rev_num * 10 + num % 10;
			num = num / 10;
		}
		return rev_num;
	}

}
