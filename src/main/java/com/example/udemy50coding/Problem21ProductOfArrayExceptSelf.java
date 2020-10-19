package com.example.udemy50coding;

import java.util.Arrays;

public class Problem21ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		int[] a = {2, 5, 7, 4, 3};
		int[] output = productExceptSelf(a);
		Arrays.stream(output).forEach(s -> System.out.print(s + " "));
	}
	
	// By using cumulative product:
	// Time complexity: O(n)
	// Space complexity: O(n)
	static int[] productExceptSelf(int[] arr){
	  int n = arr.length;
	  int[] cumulativeFromLeft = new int[n];
	  cumulativeFromLeft[0] = 1;
	  for(int i = 1; i < n; i++)
	    cumulativeFromLeft[i] = cumulativeFromLeft[i-1] * arr[i-1];

	  int[] cumulativeFromRight = new int[n];
	  cumulativeFromRight[n-1] = 1;
	  for(int i = n-2; i >= 0; i--)
	    cumulativeFromRight[i] = cumulativeFromRight[i+1] * arr[i+1];

	  int[] output = new int[n];
	  for(int i = 0; i < n; i++)
	    output[i] = cumulativeFromLeft[i] * cumulativeFromRight[i];
	  
	  return output;
	}
}
