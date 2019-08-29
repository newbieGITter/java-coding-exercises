package com.example.arrays;

import java.util.Arrays;

public class MinDiffBetweenTwoSubsequentElements {

	public static void main(String[] args) {
		int[] inputArray = {1, 55, 33, 19, 77, 2};
		
		findMinimumDifferenceUsingTwoLoops(inputArray);
		findMinimumDifferenceUsingSort(inputArray);
		
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
