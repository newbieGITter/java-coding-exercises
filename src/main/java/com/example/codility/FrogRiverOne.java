package com.example.codility;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {

	public static void main(String[] args) {
		int[] A = new int[] { 1, 2, 3, 4, 3, 3, 1, 2, 4, 4, 2, 1 };
		int k = 4;
		System.out.println(solution(k, A));
	}

	private static int solution(int k, int[] a) {
		Set<Integer> requiredLeavesSet = new HashSet<>();

		for (int i = 1; i <= k; i++) {
			requiredLeavesSet.add(i);
		}

		Set<Integer> currentLeavesSet = new HashSet<>();

		for (int p = 0; p < a.length; p++) {
			currentLeavesSet.add(a[p]);

			if (currentLeavesSet.size() < requiredLeavesSet.size())
				continue;

			if (currentLeavesSet.containsAll(requiredLeavesSet)) {
				return p;
			}
		}
		return -1;
	}

}
