package com.example.codility;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class OddOccurencesInArray {

	public static void main(String[] args) {
		int[] A = new int[] { 3, 9, 9, 3, 9, 7, 9, 7, 9, 3, 3, 3 };

		if (solution(A) != 0) {
			System.out.println("Odd occuring value in array is: " + solution(A));
		} else {
			System.out.println("No odd occuring value in array. ");
		}
	}

	private static int solution(int[] a) {
		Map<Integer, Integer> occurencesMap = new LinkedHashMap<>();

		for (int i = 0; i < a.length; i++) {
			if (occurencesMap.containsKey(a[i])) {
				occurencesMap.put(a[i], occurencesMap.get(a[i]) + 1);
			} else {
				occurencesMap.put(a[i], 1);
			}
		}

		Set<Integer> keySet = occurencesMap.keySet();

		for (int key : keySet) {
			int occurence = occurencesMap.get(key);

			if (occurence % 2 != 0)
				return key;
		}
		return 0;
	}

}
