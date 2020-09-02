package com.example.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindAllPairsInArrayWhoseSumEqualsGivennNumber {

	// Input:
	// On Line 1: nr of test cases. For instance: 1
	// On line 2: sum. for instance: 4
	// On LIne 3: array of integers. For instance: 1 2 3 5 6 77 66 
	// Output: (1, 3)
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int nrOfTestCases = Integer.parseInt(reader.readLine());
		Map<Integer, String> mapOfSumAndArray = new HashMap<>();

		for (int i = 0; i < nrOfTestCases; i++) {
			String sum = reader.readLine().trim();
			String arrayLine = reader.readLine();
			mapOfSumAndArray.put(i + 1, sum + ":" + arrayLine);
			findPairs(mapOfSumAndArray);
		}
	}

	private static void findPairs(Map<Integer, String> mapOfSumAndArray) {
		mapOfSumAndArray.forEach((key, value) -> {
			int sum = Integer.parseInt(value.split(":")[0]);
			String array = value.split(":")[1];
			System.out.println("sum: " + sum + ", " + "array: " + array);
			String[] split = array.split(" ");
			Set<Integer> setOfNumbers = new HashSet<>(split.length);

			for (int i = 0; i < split.length; i++) {
				int num = Integer.parseInt(split[i]);
				int target = sum - Integer.parseInt(split[i]);

				if (!setOfNumbers.contains(target)) {
					setOfNumbers.add(num);
				} else {
					System.out.printf("(%d, %d) %n", target, num);
				}
			}
		});
	}

}
