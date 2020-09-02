package com.example.arrays;

import java.util.Arrays;

public class MinDiffBetweenTwoSubsequentElements {

	public static void main(String[] args) {
		int[] inputArray = {77, 19, 191, 145};
		
		//findMinimumDifferenceUsingTwoLoops(inputArray);
		//findMinimumDifferenceUsingSort(inputArray);
		findMinimumDifferenceUsingTwoLoops_booking(inputArray);
		findMinimumDifferenceUsingSort_booking(inputArray);
		
	}

	private static void findMinimumDifferenceUsingTwoLoops_booking(int[] inputArray) {
		int length = inputArray.length;
		int diff = Integer.MAX_VALUE;
		int num1 = 0;
		int num2 = 0;
		
		for(int i = 0; i < length-1; i++) {
			for(int j = i+1; j < length; j++) {
				if(Math.abs(inputArray[i] - inputArray[j]) < diff) {
					diff = Math.abs(inputArray[i] - inputArray[j]);
					num1 = inputArray[i];
					num2 = inputArray[j];
				}
			}
		}
		System.out.println("Minimum difference between 2 elements in the given array is: " + diff);
		System.out.println("Numbers are: " + num1 +", " + num2);
	}
	
	// O(n2)
	private static void findMinimumDifferenceUsingTwoLoops(int[] inputArray) {
		int length = inputArray.length;
		int diff = Integer.MAX_VALUE;
		
		for(int i = 0; i < length-1; i++){
			for(int j = i + 1; j < length; j++){
				if(Math.abs(inputArray[i] - inputArray[j]) < diff){
					diff = Math.abs(inputArray[i] - inputArray[j]);
				}
			}
		}
		
		System.out.println("Minimum difference between 2 elements in the given array is: " + diff);
	}
	
	private static void findMinimumDifferenceUsingSort_booking(int[] inputArray) {
		Arrays.sort(inputArray);
		int diff = Integer.MAX_VALUE;
		int num1 = 0, num2 = 0;
		
		for(int i = 0; i < inputArray.length-1; i++) {
			if(Math.abs(inputArray[i] - inputArray[i+1]) < diff) {
				diff = Math.abs(inputArray[i] - inputArray[i+1]);
				num1 = inputArray[i];
				num2 = inputArray[i+1];
			}
		}
		System.out.println("Minimum difference between 2 elements in the given array is: " + diff);
		System.out.println("Two numbers are: " + num1 + ", " + num2);
	}
	
	// O(n Log n)
	private static void findMinimumDifferenceUsingSort(int[] inputArray){
		Arrays.sort(inputArray);
		
		int diff = Integer.MAX_VALUE;
		
		for(int i = 0; i < inputArray.length-1; i++){
			if(Math.abs(inputArray[i+1] - inputArray[i]) < diff){
				diff = Math.abs(inputArray[i] - inputArray[i+1]);
			}
		}
		
		System.out.println("Minimum difference between 2 elements in the given array is: " + diff);
	}
}
