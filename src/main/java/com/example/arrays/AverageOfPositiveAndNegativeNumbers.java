package com.example.arrays;

import java.util.Arrays;

public class AverageOfPositiveAndNegativeNumbers {

	public static void main(String[] args) {
		int[] inputArr = {5, 3, -23, 55, 66, 88, -34, -12, 33, 11};
		
		findAverages(inputArr);
		findAverages_2(inputArr);
		findAverages_3(inputArr);
	}

	private static void findAverages(int[] inputArr) {
		System.out.println("Sum of positive numbers: " + Arrays.stream(inputArr).filter(x -> x >= 0).sum());
		System.out.println("Average of positive numbers: " + Arrays.stream(inputArr).filter(x -> x >= 0).average());
		
		System.out.println("Sum of negative numbers: " + Arrays.stream(inputArr).filter(x -> x < 0).sum());
		System.out.println("Average of negative numbers: " + Arrays.stream(inputArr).filter(x -> x < 0).average());
	}
	
	private static void findAverages_2(int[] inputArr) {
		System.out.println("===================");
		System.out.println("Inside findAverages_2()");
		System.out.println("Avg of positive numbers: " + Arrays.stream(inputArr).filter(x -> x >= 0).average());
		System.out.println("Avg of negative numbers: " + Arrays.stream(inputArr).filter(x -> x < 0).average());
	}
	
	private static void findAverages_3(int[] inputArr) {
		System.out.println("=========================");
		System.out.println("Inside find_Averages_3");
		System.out.println("Average of positive numbers: "+ Arrays.stream(inputArr).filter(x -> x >= 0).average());
		System.out.println("Average of negative numbers: " + Arrays.stream(inputArr).filter(x -> x <=0).average());
	}
}
