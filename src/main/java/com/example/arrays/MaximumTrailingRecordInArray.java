package com.example.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaximumTrailingRecordInArray {

	public static void main(String[] args) {
		int arr[] = {5, 3, 13, 15, 2};
		
		System.out.println(arr.length);
		List<Integer> levels = Arrays.stream(arr).boxed().collect(Collectors.toList());
		int maxTrailingRecord = getMaxTrailingRecord(levels);
		System.out.println("Max Trailing Record is: " + maxTrailingRecord);
	}

	private static int getMaxTrailingRecord(List<Integer> levels) {
		int listSize = levels.size();
		int maxTrailingRecord = -1;
		
		for (int i = listSize; i > 0; i--) {
			int baseNum = levels.get(i-1);
			// System.out.println("base num:" + baseNum);

			for (int j = 0; j <= i - 2; j++) {
				if (baseNum > levels.get(j)) {
					int temp = baseNum - levels.get(j);
					if (temp > maxTrailingRecord) {
						maxTrailingRecord = temp;
					}
				}
			}
			System.out.println(
					"Base num: " + baseNum + ", Iteration i: " + i + ", maxTrailing Record is: " + maxTrailingRecord);
		}
		return maxTrailingRecord;
	}

}
