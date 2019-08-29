package com.example.strings;

public class CalculateFrequencyInStringArray {

	public static void main(String[] args) {
		String[] inputArray = {"aba", "baba", "aba", "xzxb"};
		String[] query = {"aba", "baba", "ffff"};
		
		printCountOfSubstrings(inputArray, query);
	}

	private static void printCountOfSubstrings(String[] inputArray, String[] query) {
		for(int i = 0; i < query.length; i++){
			int count = 0;
			
			for(int j = 0; j < inputArray.length; j++){
				if(query[i].equalsIgnoreCase(inputArray[j])){
					count++;
				}
			}
			System.out.println("Input String: " + query[i] + " occured " + count + " times");
			System.out.println("==============================");
		}
	}

}
