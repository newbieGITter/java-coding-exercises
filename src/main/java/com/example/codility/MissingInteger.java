package com.example.codility;

import java.util.Set;
import java.util.TreeSet;

public class MissingInteger {

	public static void main(String[] args) {
		int[] A = new int[] { 3, 6, 5, 4, 2 };

		System.out.println("Missing integer is: " + solution(A));
	}

	// Another solution is in FindMissingNumberInUnsortedArray.java
	private static int solution(int[] A) {
		Set<Integer> testedSet = new TreeSet<>();
		Set<Integer> perfectSet = new TreeSet<>();

		for (int i = 0; i < A.length; i++) {
			testedSet.add(A[i]); // convert array to set to get rid of duplicates, order int's
			perfectSet.add(i + 1); // create perfect set so can find missing int
		}

		for (int current : perfectSet) {
			if (!testedSet.contains(current)) {
				return current;
			}
		}

		if (perfectSet.size() == testedSet.size()) {
			return perfectSet.size() + 1; // e.g. {1, 2, 3} should return 4
		}

		return 1; // default - e.g. if A array has negative values or just a single positive value
					// like 10
	}

}
