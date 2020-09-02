package com.example.streams;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class IntStreamExample {

	public static void main(String[] args) {
		int numbers[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		IntStream stream = IntStream.of(numbers);

		int minNumber = stream.min().getAsInt();
		System.out.println("Minimum nr in array is: " + minNumber);

		// Getting IntSummaryStatistics
		IntSummaryStatistics summaryStatistics = stream.summaryStatistics();
		System.out.println("Min nr in array is: " + summaryStatistics.getMin());
		System.out.println("Max nr in array is: " + summaryStatistics.getMax());
		System.out.println("Average of array is: " + summaryStatistics.getAverage());
		System.out.println("Count of array is: " + summaryStatistics.getCount());
		System.out.println("Sum of array is: " + summaryStatistics.getSum());

		// Finding 3 distinct number from array
		int sumOfFirstThreeNr = stream.sorted().limit(3).sum(); // We can use count(), average(), min(), max()
		System.out.println("Sum of first 3 numbers: " + sumOfFirstThreeNr);
		
		stream.distinct();  // returns a stream of distinct numbers from array
		stream.sorted();    // returns sorted stream
		stream.limit(3);    // returns stream of top 3 elements 
		stream.skip(3);    // returns stream with first 3 elements skipped
		stream.filter(n -> n % 2 == 0); // returns stream of only even numbers
		stream.map(n -> n*2);           // returns stream of all numbers which are doubled
		stream.boxed();  // converts all ints into Integer & return stream

	}

}
