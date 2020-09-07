package com.example.codility;

import java.util.HashSet;
import java.util.Set;

public class PermMissingElement {

	public static void main(String[] args) {
		int[] A = new int [] { 4, 2, 3, 1, 5, 8, 7 };
		
		int missingElement = solution(A);
		if(missingElement != 0) {
			System.out.println("Missing element in the array is: " + missingElement);
		} else {
			System.out.println("No missing element in the array. ");
		}
	}

	private static int solution(int[] A) {
		int max = A.length + 1;
		   
	    //load array elements into set so would be quick to check if elements exist
	    Set<Integer> incompleteSet = new HashSet<>();
	    for(int i=0; i<A.length; i++) {
	      incompleteSet.add(A[i]);
	    }

	    for(int i=1; i<max+1; i++) {
	      if(!incompleteSet.contains(i)) {
	        return (i);
	      }
	    }
	    return 0;
	}

}
