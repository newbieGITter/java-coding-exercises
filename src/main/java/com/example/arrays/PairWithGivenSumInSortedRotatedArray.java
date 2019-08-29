package com.example.arrays;

public class PairWithGivenSumInSortedRotatedArray {

	public static void main(String[] args) {
		int[] inputArr = {11, 15, 6, 7, 9, 10};
		int sum = 17;
		
		System.out.println("Count of pair with sum as :" + sum + " is " + findPairWithGivenSum(inputArr, inputArr.length, sum));
		
	}

	private static int findPairWithGivenSum(int[] inputArr, int nrOfElements, int sum) {
		
		// Find the pivot element (Pivot element is the largest element of the array
		int i = 0;
		
		for(i = 0; i < inputArr.length; i++) {
			if(inputArr[i] > inputArr[i + 1]) {
				break;
			}
		}
		
		// left is index of smallest element
		int left = (i + 1) % nrOfElements;
		
		// right is index of largest element
		int right = i;
		
		// Variable to store count of number of pairs
		int count = 0;
		
		// Find sum of pair formed by arr[left] and arr[right] and update left, right and count accordingly
		while(left != right) {
			// If we find a pair with  
	        // sum x, then increment  
	        // cnt, move l and r to  
	        // next element. 
	        if (inputArr[left] + inputArr[right] == sum) 
	        { 
	        	count++; 
	              
	            // This condition is required  
	            // to be checked, otherwise  
	            // l and r will cross each  
	            // other and loop will never  
	            // terminate. 
	            if(left == (right - 1 + nrOfElements) % nrOfElements) 
	            { 
	                return count; 
	            } 
	              
	            left = (left + 1) % nrOfElements; 
	            right = (right - 1 + nrOfElements) % nrOfElements; 
	        } 
	  
	        // If current pair sum  
	        // is less, move to  
	        // the higher sum side. 
	        else if (inputArr[left] + inputArr[right] < sum) 
	            left = (left + 1) % nrOfElements; 
	          
	        // If current pair sum  
	        // is greater, move  
	        // to the lower sum side. 
	        else
	            right = (nrOfElements + right - 1) % nrOfElements; 
		}
		return count;
	}

}
