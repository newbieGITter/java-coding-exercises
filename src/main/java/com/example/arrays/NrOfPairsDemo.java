package com.example.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class NrOfPairsDemo {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int nrOfTestCases = Integer.parseInt(reader.readLine());
		Map<Integer, String> inputMap = new HashMap<>();

		for (int i = 0; i < nrOfTestCases; i++) {
			String elementsSize = reader.readLine();
			String firstArrayElements = reader.readLine();
			String secondArrayElements = reader.readLine();

			String concatenatedInput = elementsSize + ":" + firstArrayElements + ":" + secondArrayElements;

			inputMap.put(i + 1, concatenatedInput);

			Set<Entry<Integer,String>> entrySet = inputMap.entrySet();
			for (Entry<Integer, String> entry : entrySet) {
				findPairs(entry.getValue());
			}
		}
	}

	private static void findPairs(String inputValue) {
		String[] inputStringArray = inputValue.split(":");
		
		String elementsSize = inputStringArray[0];
		String[] elementsSizeSplit = elementsSize.split(" ");
		int firstArrayElementSize = Integer.parseInt(elementsSizeSplit[0]);
		int secondArrayElementSize = Integer.parseInt(elementsSizeSplit[1]);

		String firstArrayElements = inputStringArray[1];
		String[] firstArrayElementsSplit = firstArrayElements.split(" ");
		
		String secondArrayElements = inputStringArray[2];
		String[] secondArrayElementsSplit = secondArrayElements.split(" ");
		
		validateFirstArray(firstArrayElementSize, firstArrayElementsSplit);
		validateSecondArray(secondArrayElementSize, secondArrayElementsSplit);
		
		int count = 0;
		for(int i = 0; i < firstArrayElementsSplit.length; i++) {
			for(int j = 0; j < secondArrayElementsSplit.length; j++ ) {
				Double firstValue = Math.pow(Double.parseDouble(firstArrayElementsSplit[i]), Double.parseDouble(secondArrayElementsSplit[j]));
				Double secondValue = Math.pow(Double.parseDouble(secondArrayElementsSplit[j]), Double.parseDouble(firstArrayElementsSplit[i]));
				
				if(firstValue > secondValue) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

	private static void validateSecondArray(int secondArrayElementSize, String[] secondArrayElementsSplit) {
		if(secondArrayElementSize != secondArrayElementsSplit.length) {
			System.out.println("Second array element size is not equal to the elements specified. Please correct it!");
		}
	}

	private static void validateFirstArray(int firstArrayElementSize, String[] firstArrayElementsSplit) {
		if(firstArrayElementSize != firstArrayElementsSplit.length) {
			System.out.println("First array element size is not equal to the elements specified. Please correct it!");
		}
	}
}
