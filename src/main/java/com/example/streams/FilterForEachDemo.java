package com.example.streams;

import java.util.Arrays;
import java.util.List;


public class FilterForEachDemo {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Peter", "Shiva", "Virender", "Sachin");
		
		System.out.println("Filtering out name 'Peter' from the list");
		names.stream().filter(n -> !n.equalsIgnoreCase("Peter")).forEach(System.out::println);
		
		System.out.println("Filtering out names which do not start with 'S'");
		names.stream().filter(n -> n.startsWith("S")).forEach(System.out::println);
		
	}

}
