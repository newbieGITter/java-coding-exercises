package com.example.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortArrayWithoutChangingPositionOfNegativeNr {

	public static void main(String[] args) {
		int[] inputArr = {2, -6, -3, 8, 4, 1};
		int length = inputArr.length;
		
		System.out.println("Input array is: ");
		displayArray(inputArr);
		
		sortArray(inputArr, length);
		
		System.out.println("================");
		System.out.println("Sorted Array is: ");
		displayArray(inputArr);
	}

	private static void displayArray(int[] inputArr) {
		Arrays.stream(inputArr).forEach(x -> System.out.println(x));
	}

	private static void sortArray(int[] inputArr, int length) {
		List<Integer> positiveNumbersList = new ArrayList<>();
		
		for(int i = 0; i < inputArr.length; i++) {
			if(inputArr[i] >= 0) {
				positiveNumbersList.add(inputArr[i]);
			}
		}

		List<Integer> sortedList = positiveNumbersList.stream().sorted().collect(Collectors.toList());
		
		int j = 0;
		for(int i = 0; i < inputArr.length; i++) {
			if(inputArr[i] >= 0) {
				inputArr[i] = sortedList.get(j);
				j++;
			}
		}
		
	}
	
}
