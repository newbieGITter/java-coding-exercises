package com.example.strings;

public class ConvertCamelCaseStringToSnakeCaseString {

	public static void main(String[] args) {
		String str = "ThisIsCamelCaseStringInJava";
		System.out.println("Snake case string is: " + convertCamelCaseToSnakeCase(str));
	}

	private static String convertCamelCaseToSnakeCase(String str) {
		StringBuilder result = new StringBuilder();
		
		result.append(Character.toLowerCase(str.charAt(0)));
		
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) >= 65 && str.charAt(i) <= 90) {
				result.append("_");
				result.append(Character.toLowerCase(str.charAt(i)));
			}
			else {
				result.append(Character.toLowerCase(str.charAt(i)));
			}
		}
		return result.toString();
	}
}
