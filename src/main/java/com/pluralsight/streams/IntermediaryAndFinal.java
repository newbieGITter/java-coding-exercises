package com.pluralsight.streams;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class IntermediaryAndFinal {

	public static void main(String[] args) {
		Stream<String> streams = Stream.of("one", "two", "three", "four", "five");

		//streams.forEach(s -> System.out.println(s));
		//streams.forEach(System.out::println); // another way using method reference
		
		Predicate<String> p1 = s -> s.length() > 3; 
		
		Predicate<String> p2 = s -> s.length() < 5;
		
		//streams.filter(p1).forEach(System.out::println);
		
		streams.filter(p1.and(p2)).forEach(System.out::println);
	}

}
