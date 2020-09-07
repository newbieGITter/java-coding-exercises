package com.example.arrays;

import java.util.Arrays;

public class FindMissingNumberInUnsortedArray {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 6, 4, 5, 1 };

		System.out.println(solution(arr));
	}
	
	public static int solution(int[] arr) {
		int total_num = (int)Arrays.stream(arr).sorted().count();
		System.out.println(total_num);
		int expectedSum = (total_num * (total_num + 1)) / 2;
		System.out.println(expectedSum);
		
		int sumOfArrayNumbers = Arrays.stream(arr).distinct().sum();
		System.out.println(sumOfArrayNumbers);
		
		return expectedSum - sumOfArrayNumbers;
	}
}
