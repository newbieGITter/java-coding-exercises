package com.example.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommonCharacterIn2Strings {

	// INput : String s1 = "saahas", s2 = "poorthi"; 
	// output: Yes
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str1 = scan.nextLine();
		String str2 = scan.nextLine();
		
		System.out.println(str1 + " " + str2);
		
		if(checkCommonCharacter(str1, str2).length() > 0){
			System.out.println("Yes");
			System.out.println("Matching characters in two strings are: " + checkCommonCharacter(str1, str2));
		} else {
			System.out.println("No");
		}
		scan.close();
	}

	private static StringBuilder checkCommonCharacter(String str1, String str2) {
		Map<Character, Integer> mp = new HashMap<>();
		
		for(int i = 0; i < str1.length(); i++){
	        mp.put(str1.charAt(i), mp.get(str1.charAt(i)) == null ? 1 : mp.get(str1.charAt(i)) + 1); 
		}
		
		StringBuilder matchingStr = new StringBuilder("");
		for (int i = 0; i < str2.length(); i++)  
	    { 
	        if (mp.get(str2.charAt(i)) != null && mp.get(str2.charAt(i)) > 0)  
	        { 
	        	matchingStr.append(str2.charAt(i));
	        } 
	    }
		return matchingStr;
	}
}
