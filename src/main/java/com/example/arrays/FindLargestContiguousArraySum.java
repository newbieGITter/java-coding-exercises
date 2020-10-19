package com.example.arrays;

public class FindLargestContiguousArraySum {

	public static void main(String[] args) {
		int[] a = { -2, 9, -2, 3, -2, 1, 3, -1 };
		maxSubArraySum(a);
	}

	static void maxSubArraySum(int a[]) {
		int max_so_far = Integer.MIN_VALUE, max_ending_here = 0, start = 0, end = 0, s = 0;

		for (int i = 0; i < a.length; i++) {
			max_ending_here += a[i];

			if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
				start = s;
				end = i;
			}

			if (max_ending_here < 0) {
				max_ending_here = 0;
				s = i + 1;
			}
		}
		System.out.println("Maximum contiguous sum is " + max_so_far);
		System.out.println("Starting index " + start);
		System.out.println("Ending index " + end);
	}

}
