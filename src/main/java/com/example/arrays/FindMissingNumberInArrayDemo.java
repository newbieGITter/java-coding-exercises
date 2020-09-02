package com.example.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FindMissingNumberInArrayDemo {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// 1 2 4 5 6 -- missing number is 3
		// Reading data using readLine
		int nrOfTestCases = Integer.parseInt(reader.readLine());

		Map<Integer, String> inputMap = new HashMap<>();

		for (int i = 0; i < nrOfTestCases; i++) {
			String nrOfElementsInArray = reader.readLine().trim();
			String elements = reader.readLine();
			inputMap.put(i + 1, nrOfElementsInArray + ":" + elements);
		}

		Set<Entry<Integer, String>> entrySet = inputMap.entrySet();
		for (Entry<Integer, String> entry : entrySet) {
			//findMissingNumberFromArray(entry.getKey(), entry.getValue());
			//findMissingNumberFromArrayUsingXor(entry.getKey(), entry.getValue());
			//findMissingNumberUsingPrimitive(entry.getKey(), entry.getValue());
			System.out.println(findmissing(entry.getKey(), entry.getValue()));
		}
	}

	private static int findmissing(Integer key, String elements) {
		String[] split = elements.split(":");
		int nrOfElements = Integer.parseInt(split[0]);
		String strArray = split[1];
		int[] ar = Arrays.stream(strArray.split(" ")).mapToInt(Integer::parseInt).toArray();


		int l = 0, r = nrOfElements - 1;
		while (l <= r) {
			int mid = (l + r) / 2;

			// If this is the first element
			// which is not index + 1, then
			// missing element is mid+1
			if (ar[mid] != mid + 1 && ar[mid - 1] == mid)
				return (mid + 1);

			// if this is not the first
			// missing element search
			// in left side
			if (ar[mid] != mid + 1)
				r = mid - 1;

			// if it follows index+1
			// property then search
			// in right side
			else
				l = mid + 1;
		}

		// if no element is missing
		return -1;
	}

	// 2
	// 5
	// 1 2 3 4 6
	// 8
	// 11 12 13 14 15 17 18 19
	private static void findMissingNumberUsingPrimitive(Integer key, String elements) {
		String[] split = elements.split(":");
		int nrOfElements = Integer.parseInt(split[0]);
		String strArray = split[1];
		int[] array = Arrays.stream(strArray.split(" ")).mapToInt(Integer::parseInt).toArray();

		for (int i = 0; i < nrOfElements - 1; i++) {
			if (array[i + 1] - array[i] > 1) {
				System.out.println(" Missing number is: " + array[i] + 1);
			}
		}
	}

	private static void findMissingNumberFromArrayUsingXor(Integer key, String elements) {
		String[] split = elements.split(":");
		int nrOfElements = Integer.parseInt(split[0]);
		String strArray = split[1];
		int[] array = Arrays.stream(strArray.split(" ")).mapToInt(Integer::parseInt).toArray();
		int x1 = array[0];
		int x2 = 1;

		/*
		 * For xor of all the elements in array
		 */
		for (int i = 1; i < nrOfElements; i++)
			x1 = x1 ^ array[i];

		/*
		 * For xor of all the elements from 1 to n+1
		 */
		for (int i = 2; i <= nrOfElements + 1; i++)
			x2 = x2 ^ i;

		System.out.println("Missing number using xor is: " + (x1 ^ x2));
	}

	private static void findMissingNumberFromArray(Integer key, String elements) {
		String[] split = elements.split(":");
		int nrOfElements = Integer.parseInt(split[0]);
		String array = split[1];
		String[] splitArray = array.split(" ");

		int sumOfElements = 0;
		for (String s : splitArray) {
			sumOfElements += Integer.parseInt(s);
		}
		int sumOfArrayElements = getSumOfArrayElements(nrOfElements);

		int missingNumber = sumOfArrayElements - sumOfElements;
		System.out.println("Missing number using approach 1: " + missingNumber);
	}

	private static int getSumOfArrayElements(Integer nrOfElements) {
		return ((nrOfElements + 1) * (nrOfElements + 2)) / 2;
	}

}
