package com.example.udemy50coding;

public class Problem10FindingPeakRecordIndex {

	public static void main(String[] args) {
		int[] arr = { 3, 1, 4, 2, 5, 4, 6, 1 };
		System.out.println("Peak element is at index: (1) " + findPeak_TraversingWholeArray(arr));
		System.out.println("Peak element is at index (2): " + findPeak_UsingDivideAndConquerIteratively(arr));
		System.out.println("Peak element is at index (2): " + findPeak_UsingDivideAndConquerRecursively(arr));
	}

	// Time complexity: O(n)
	// Space complexity: O(1)
	public static int findPeak_TraversingWholeArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if ((i == 0 || arr[i] > arr[i - 1]) && (i == arr.length - 1 || arr[i] > arr[i + 1])) {
				return i;
			}
		}
		return -1;
	}

	// Time complexity: O(logn)
	// Space complexity: O(1)
	private static int findPeak_UsingDivideAndConquerIteratively(int[] arr) {
		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			int mid = (left + right) / 2;

			if (arr[mid] < arr[mid + 1])
				left = mid + 1;
			else
				right = mid;
		}
		return left;
	}
	
	// Time complexity: O(logn)
	// Space complexity: O(1)
	static int findPeak_UsingDivideAndConquerRecursively(int[] arr, int left, int right){
	  if(left >= right) return left;
	  int mid = (left + right)/2;
	  if(arr[mid] < arr[mid+1])
	    return findPeak_UsingDivideAndConquerRecursively(arr, mid+1, right);
	  else
	    return findPeak_UsingDivideAndConquerRecursively(arr, left, mid);
	}

	static int findPeak_UsingDivideAndConquerRecursively(int[] arr){
	  return findPeak_UsingDivideAndConquerRecursively(arr, 0, arr.length-1);
	}
}
