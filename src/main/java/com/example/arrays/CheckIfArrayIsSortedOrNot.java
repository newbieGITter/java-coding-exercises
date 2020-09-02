package com.example.arrays;

public class CheckIfArrayIsSortedOrNot {

	public static void main(String[] args) {
		int a[] = new int[] { 1, 2, 2, 2, 2, 2, 3, 3, 5, 5 };

		if(isSorted(a, a.length)) {
			System.out.println("Given array is sorted.");
		} else {
			System.out.println("Given array is not sorted. ");
		}
	}
	
	private static boolean isSorted(int[] array, int length) {
	    if (array == null || length < 2) 
	        return true; 
	    if (array[length - 2] > array[length - 1])
	        return false;
	    return isSorted(array, length - 1);
	}
	
	boolean isSorted_2(int[] array) {
	    for (int i = 0; i < array.length - 1; i++) {
	        if (array[i] > array[i + 1])
	            return false;
	    }
	    return true;
	}

}
