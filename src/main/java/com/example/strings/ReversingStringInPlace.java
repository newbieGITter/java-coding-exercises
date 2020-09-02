package com.example.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReversingStringInPlace {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String inputString = reader.readLine();
		System.out.println("Input String is: " + inputString);
		
		String reverseString = reverseString(inputString);
		System.out.println("Reverse String is: " + reverseString);
		
		if(inputString.equalsIgnoreCase(reverseString)) {
			System.out.println("Input string is an Anagram. ");
		} else {
			System.out.println("Input string is NOT an Anagram. ");
		}
	}

	private static String reverseString(String inputString) {
		char[] charArray = inputString.toCharArray();
		char temp;
		for(int i = 0; i < charArray.length/2; i++) {
			temp = charArray[i];
			charArray[i] = charArray[charArray.length-i-1];
			charArray[charArray.length-i-1] = temp;
		}
		return new String(charArray);
	}

}
