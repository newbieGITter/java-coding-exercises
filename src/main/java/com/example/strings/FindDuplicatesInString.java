package com.example.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicatesInString {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String inputString = reader.readLine();

		findDuplicatesInString(inputString);
	}

	private static void findDuplicatesInString(String inputString) {
		Set<Character> repeating = new HashSet<>();
		List<Character> nonRepeating = new ArrayList<>();

		for (int i = 0; i < inputString.length(); i++) {
			char letter = inputString.charAt(i);

			if (repeating.contains(letter)) {
				continue;
			}

			if (nonRepeating.contains(letter)) {
				nonRepeating.remove((Character) letter);
				repeating.add(letter);
			} else {
				nonRepeating.add(letter);
			}
		}
		if (repeating.size() > 0) {
			System.out.print("Duplicates in the given array are: ");
			repeating.stream().forEach(s -> System.out.print(s + " "));
		} else {
			System.out.println("No duplicates in the given array.");
		}

		System.out.println(" ");
		if (nonRepeating.size() > 0) {
			System.out.println("Unique values in the given array are:");
			nonRepeating.stream().forEach(s -> System.out.println(s + " "));
		} else {
			System.out.println("No unique values in the given array.");
		}
	}

}
