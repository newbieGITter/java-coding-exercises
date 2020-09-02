package com.example.arrays;

import java.util.Arrays;

public class ReversingIntegerArrayInPlace {

	// Input: 3 5 6 4 7 33 54 22 77 99 86 1 2
	// output:2 1 86 99 77 22 54 33 7 4 6 5 3 
	public static void main(String[] args) {
		
		int[] inputArray = {3, 5, 6, 7, 77, 78, 89, 23, 21, 18, 10, 2};
		System.out.println("Given array is: ");
		Arrays.stream(inputArray).forEach(s -> System.out.print(s + " "));
		System.out.println(" ");
		reverseArray(inputArray);
	}

	private static void reverseArray(int[] inputArray) {
		int temp = 0;
		
		for(int i = 0; i < inputArray.length / 2; i++) {
			temp = inputArray[i];
			inputArray[i] = inputArray[inputArray.length-i-1];
			inputArray[inputArray.length-i-1] = temp;
		}
		System.out.println("Reversed Array is: ");
		Arrays.stream(inputArray).forEach(s -> System.out.print(s + " "));
	}
}
