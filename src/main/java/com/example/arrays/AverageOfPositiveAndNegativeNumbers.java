package com.example.arrays;

import java.util.Arrays;

public class AverageOfPositiveAndNegativeNumbers {

	public static void main(String[] args) {
		int[] inputArr = {5, 3, -23, 55, 66, 88, -34, -12, 33, 11};
		
		findAverages(inputArr);
	}

	private static void findAverages(int[] inputArr) {
		System.out.println("Sum of positive numbers: " + Arrays.stream(inputArr).filter(x -> x >= 0).sum());
		System.out.println("Average of positive numbers: " + Arrays.stream(inputArr).filter(x -> x >= 0).average());
		
		System.out.println("Sum of negative numbers: " + Arrays.stream(inputArr).filter(x -> x < 0).sum());
		System.out.println("Sum of negative numbers: " + Arrays.stream(inputArr).filter(x -> x < 0).average());
	}
}
