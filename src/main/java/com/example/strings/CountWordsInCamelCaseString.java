package com.example.strings;

public class CountWordsInCamelCaseString {

	public static void main(String[] args) {
		String str = "geeksForGeeksString";
		
		System.out.println("nr of words in string is: " + countWordsInCamelCase(str));
	}

	private static int countWordsInCamelCase(String str) {
		int count = 1;
		
		for(int i = 1; i < str.length(); i++) {
			
			if(str.charAt(i) >= 65 && str.charAt(i) <= 90) {
				count++;
			}
		}
		return count;
	}
}
