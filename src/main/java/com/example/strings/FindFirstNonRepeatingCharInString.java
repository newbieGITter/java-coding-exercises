package com.example.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FindFirstNonRepeatingCharInString {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String inputString = reader.readLine();
		System.out.println("First non repeating char in given string is: " +findFirstNonRepeatingChar_UsingTwoLoops(inputString));
		System.out.println("First non repeating char in given string is: " +findFirstNonRepeatingChar_InOneLoop(inputString));
		
	}

	private static char findFirstNonRepeatingChar_UsingTwoLoops(String inputString) {
		Map<Character, Integer> counts = new LinkedHashMap<>();

		for (char c : inputString.toCharArray()) {
			counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
		}

		for (Entry<Character, Integer> entry : counts.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
        throw new RuntimeException("didn't find any non repeated Character");
	}
	
	private static char findFirstNonRepeatingChar_InOneLoop(String inputString) {
		Set<Character> repeating = new HashSet<>();
		List<Character> nonRepeating = new ArrayList<>();
		
		for(int i = 0; i < inputString.length(); i++) {
			char letter = inputString.charAt(i);
			if(repeating.contains(letter)) {
				continue;
			}
			
			if(nonRepeating.contains(letter)) {
				nonRepeating.remove((Character)letter);
				repeating.add(letter);
			} else {
				nonRepeating.add(letter);
			}
		}
		return nonRepeating.get(0);
	}

}
