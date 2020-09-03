package com.example.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndCollectDemo {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Pamela", "Shiva", "Cheryl", "Sachin");

		// Native way of using streams map()
		// names.stream().map(new Function<String, User>() {
		// @Override
		// public User apply(String name) {
		// return new User(name);
		// }
		// }).forEach(System.out::println);

		// Simple way to use .map()
		// names.stream().map(name -> new
		// User(name)).forEach(System.out::println);

		// Simplest way to use .map()
		names.stream().map(User::new).forEach(System.out::println);

		// Collecting all the names in a list after using map()
		List<User> userList = names.stream().map(User::new).collect(Collectors.toList());
		System.out.println(userList.size());

		// Using map() to prefix "Mr." before every name in the list
		names.stream().map(name -> "Mr. " + name).forEach(System.out::println);
		// names.stream().peek(name -> "Mr." +
		// name).forEach(System.out::println);

		// Converting all names to Uppercase
		names.stream().map(String::toUpperCase).forEach(System.out::println);

		System.out.println("=========================================================");
		System.out.println("Printing only user names who are MALE");
		names.stream().map(User::new).filter(user -> user.getGender().equalsIgnoreCase("Male"))
				.forEach(user -> System.out.println(user.getName()));

		// Using map() to apply some logic to each number in a numberList
		List<Integer> numberList = Arrays.asList(3, 5, 7, 9, 11);
		numberList.stream().map(num -> num * num).forEach(System.out::println);

	}

}
