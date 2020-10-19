package com.pluralsight.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambda {

	public static void main(String[] args) {
		// Before Java 8
		Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return Integer.compare(s1.length(), s2.length());
			}
		};
		
		Comparator<String> compLambda = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());
		
		List<String> stringList = Arrays.asList("Saahas", "Saa", "Rahul", "Panka", "Saurabh");
		//Collections.sort(stringList, comp);
		Collections.sort(stringList, compLambda); // using lambda instance
		
		for(String s: stringList) {
			System.out.println(s);
		}
	}
}
