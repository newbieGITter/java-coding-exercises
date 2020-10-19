package com.pluralsight.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FirstPredicate {

	public static void main(String[] args) {
		Stream<String> streams = Stream.of("one", "two", "three", "four", "five");

		Predicate<String> p1 = Predicate.isEqual("two");
		
		Predicate<String> p2 = Predicate.isEqual("three");
		
		List<String> list = new ArrayList<>();
		
		streams.peek(System.out::println)
			   .filter(p1.or(p2))
			   //.peek(list::add); // Because peek() is an intermediary operation and filter is also an intermediary operation, nothing will be printed.
			   .forEach(list::add); // As forEach is a terminal(final) operation & it consumes the stream. Only a final operation triggers processing of data. 
		
		System.out.println("List size: " + list.size());
			   
	}

}
