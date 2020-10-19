package com.example.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapToIntExample {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Saahas", "Rahul", "Saurabh", "Pankaj", "Aatish", "Arun", "Pavan", "Arun");
		names.sort(Comparator.comparing(String::toString));
		
	//	Map<String, Integer> collect = names.stream().distinct().sorted(Comparator.naturalOrder()).collect(Collectors.toMap(Function.identity(), String::length));
	//	collect.forEach((key, value) -> System.out.println(key + ":" + value));

		List<User> users = names.stream().filter(n -> !n.startsWith("S")).map(User::new).collect(Collectors.toList());
		int sum = users.stream().mapToInt(User::getAge).sum();
		System.out.println("Sum of age of all users: " + sum);
		System.out.println("================================================================");

		Map<String, Integer> namesLengthMap = names.stream().sorted((name1, name2) -> name2.length() - name1.length())
				.collect(Collectors.toMap(Function.identity(), String::length, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));
		namesLengthMap.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
		
		// We can also use Comparator.comparing method to compare values in streams
		System.out.println("==================================================================");
		Optional<User> maxOptional = names.stream().map(User::new).max(Comparator.comparing(User::getAge));
		System.out.println("Eldest user is: " + maxOptional.get().getName());


		System.out.println("==================================================================");
		Map<Integer, Set<String>> len2StringMap = names.stream().collect(
				Collectors.groupingBy(String::length, Collectors.mapping(Function.identity(), Collectors.toSet())));
		len2StringMap.forEach((key, value) -> System.out.println(key + " : " + value));

		System.out.println("================================================================");
		System.out.println("Printing numbers based on a condition using mapToInt()");
		List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

		numbers.stream().mapToInt(num -> Integer.parseInt(num)).filter(num -> num % 2 == 0)
				.forEach(System.out::println);

		System.out.println("================================================================");
		System.out.println("Printing string based on a condition using mapToInt()");
		List<String> strings = Arrays.asList("This", "is", "a", "dummy", "example", "not", "a", "production", "ready",
				"code");
		strings.stream().mapToInt(str -> str.length()).forEach(System.out::println);

		System.out.println("================================================================");
		System.out.println("");
		Map<String, String> books = new HashMap<>();
		books.put("978-0201633610", "Design patterns : elements of reusable object-oriented software");
		books.put("978-1617291999", "Java 8 in Action: Lambdas, Streams, and functional-style programming");
		books.put("978-1617252533", "Java 8 in Action: Lambdas, Streams & Optional");
		books.put("978-0134685991", "Effective Java");
		books.put("978-0321356680", "Effective Java: Second Edition");

		/*
		 * Optional<String> bookKeyOptional = books.entrySet().stream() .filter(book ->
		 * "Effective Java".equalsIgnoreCase(book.getValue())) .map(Map.Entry::getKey)
		 * .findFirst(); if(bookKeyOptional.isPresent()) {
		 * System.out.println("Key of book is: " + bookKeyOptional.get()); }
		 */
		books.entrySet().stream().filter(b -> b.getValue().startsWith("Java 8")).map(Map.Entry::getValue).forEach(System.out::println);
		
		List<String> isbnCodes = books.entrySet().stream().filter(book -> book.getValue().startsWith("Effective Java"))
				.map(Map.Entry::getKey).collect(Collectors.toList());
		isbnCodes.stream().forEach(b -> System.out.println("Isbn code for book is: " + b));
		
		List<String> isbnCodesForValue = books.entrySet().stream().filter(book -> book.getValue().startsWith("Effective Java"))
				.map(Map.Entry::getValue).collect(Collectors.toList());
		isbnCodesForValue.forEach(b -> System.out.println("Isbn code Value for book is: " + b));
		
		
	}

}
