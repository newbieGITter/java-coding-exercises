package com.pluralsight.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ChainConsumers {

	public static void main(String[] args) {
		List<String> stringList = Arrays.asList("Saahas", "Saa", "Rahul", "Panka", "Saurabh");
		
		List<String> results = new ArrayList<>();
		
		Consumer<String> c1 = s -> System.out.println(s);
		Consumer<String> c2 = results::add;
		
		stringList.forEach(c1.andThen(c2));
		System.out.println("Size of the result list: " + results.size());
	}

}
