package com.example.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FindMissingNumberInArrayDemo {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Reading data using readLine
		int nrOfTestCases = Integer.parseInt(reader.readLine());
		
		Map<Integer, String> inputMap = new HashMap<>();
		
		for(int i = 0; i<nrOfTestCases; i++) {
			String numbers = reader.readLine().trim();
			String nextLine2 = reader.readLine();
			inputMap.put(i+1, numbers + ":" + nextLine2);
		}
		
		Set<Entry<Integer,String>> entrySet = inputMap.entrySet();
		
		//System.out.println("Finding Missing number");
		for (Entry<Integer, String> entry : entrySet) {
			//System.out.println("Key: " + entry.getKey() + ", Value:" + entry.getValue());			
			findMissingNumberFromArray(entry.getKey(), entry.getValue());
		}
	}

	private static void findMissingNumberFromArray(Integer key, String elements) {
		String[] split = elements.split(":");
		int nrOfElements = Integer.parseInt(split[0]);
		String array = split[1];
		
		String[] splitArray = array.split(" ");
		
		int sumOfElements = 0;
		
		for(String s: splitArray) {
			sumOfElements += Integer.parseInt(s);
		}
		
		int sumOfArrayElements = getSumOfArrayElements(nrOfElements);
		
		int missingNumber = sumOfArrayElements - sumOfElements;
		System.out.println(missingNumber);
	}

	private static int getSumOfArrayElements(Integer nrOfElements) {
		return nrOfElements * (nrOfElements+1)/2;
	}

}
