package com.example.codility;

import java.util.Arrays;

public class TapeEquilibrium {

	public static void main(String[] args) {
		int[] A = new int[] { 3, 1, 2, 4, 3 }; 
		// here the output will be 1. 
		// (first part is 3+1+2 = 6)
		// second part is 4+3 = 7). so difference between firstPart and secondPart is 1.

		System.out.println("Min difference is: " + solution(A));
	}

	private static int solution(int[] a) {
		int sumOfAllElements = Arrays.stream(a).sum();

		int minDifference = Integer.MAX_VALUE;
		int currentDifference = Integer.MAX_VALUE;
		long sumFirstPart = 0;
		long sumSecondPart = 0;

		for (int i = 0; i < a.length; i++) {
			sumFirstPart += a[i];
			sumSecondPart = sumOfAllElements - sumFirstPart;

			currentDifference = (int) Math.abs(sumFirstPart - sumSecondPart);
			minDifference = Math.min(currentDifference, minDifference);
		}
		return minDifference;
	}

}
