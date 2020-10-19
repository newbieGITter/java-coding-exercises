package com.pluralsight.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExample {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		

		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(CollectorsExample.class.getResourceAsStream("people.txt")));
				Stream<String> stream = reader.lines();

		) {

			stream.map(line -> {
				String[] s = line.split(" ");
				Person p = new Person(s[0].trim(), Integer.parseInt(s[1]));
				persons.add(p);
				return p;
			}).forEach(System.out::println);

			// Creating a map of Person Name as Key and Person object as Value(removing duplicates)
			Map<String, Person> personNameAndObjMap = persons.stream().collect(Collectors.toConcurrentMap(Person::getName, Function.identity(), (oldVal, newVal) -> oldVal));
			System.out.println("personNameAndObjMap: " + personNameAndObjMap);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Stream<Person> stream = persons.stream();

		// ****************** To find out person with Min Age ******************
		Optional<Person> opt = stream.filter(p -> p.getAge() >= 20).min(Comparator.comparing(Person::getAge));
		System.out.println(opt);
		// Optional[Person [age=31, name=Saurabh]] // will return the youngest person
		// above 20 yrs

		// 2nd way to find out min age person
		Optional<Person> minAgePersonOpt = persons.stream()
				.collect(Collectors.minBy(Comparator.comparing(Person::getAge)));
		System.out.println("minAgePersonOpt: " + minAgePersonOpt);
		// will return minAgePersonOpt: Optional[Person [age=31, name=Saurabh]]

		// ****************** To find out person with Max Age ******************
		Optional<Person> opt2 = persons.stream().max(Comparator.comparing(Person::getAge));
		System.out.println(opt2);
		// Optional[Person [age=33, name=Saahas]] // will return the oldest person

		// 2nd way to find out max age person
		Optional<Person> maxAgePersonOpt = persons.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Person::getAge)));
		System.out.println("maxAgePersonOpt: " + maxAgePersonOpt);
		// will return maxAgePersonOpt: Optional[Person [age=66, name=Rahul]]

		// ****************** To prepare map with key as Person's age and value as
		// Person object ******************
		Map<Integer, List<Person>> personByAgeMap = persons.stream().collect(Collectors.groupingBy(Person::getAge));
		System.out.println(personByAgeMap);
		// Will return {32=[Person [age=32, name=Pankaj]], 33=[Person [age=33,
		// name=Saahas], Person [age=33, name=Rahul]], 31=[Person [age=31,
		// name=Saurabh]]}

		// ****************** To prepare map with key as Person's age and value as Set
		// of names of person of that age ******************
		Map<Integer, Set<String>> personWithSetOfNamesMap = persons.stream().collect(
				Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toSet())));
		System.out.println(personWithSetOfNamesMap);
		// will return {32=[Pankaj], 33=[Saahas, Rahul], 31=[Saurabh]}

		// ****************** To prepare string with person names separated by ','
		String collect = persons.stream().map(p -> p.getName()).sorted().distinct().collect(Collectors.joining(","));
		System.out.println(collect);
		// will return Pankaj,Rahul,Saahas,Saurabh

		// ****************** To prepare map with key as person name and value as Set of
		// Person object matching that name
		Map<String, Set<Person>> personByNameMap = persons.stream()
				.collect(Collectors.groupingBy(Person::getName, Collectors.toSet()));
		// Map<String, List<Person>> personByNameMap =
		// persons.stream().collect(Collectors.groupingBy(Person::getName));
		// If we specify only one parameter in collect(), by default the collect() will
		// return a map with value as List<Object> as above
		System.out.println(personByNameMap);
		// will return {Rahul=[Person [age=33, name=Rahul], Person [age=66, name=Rahul]], Saahas=[Person [age=33, name=Saahas]], Pankaj=[Person [age=32, name=Pankaj]], Saurabh=[Person [age=31, name=Saurabh]]}

		// ****************** To prepare set of person names ******************
		Set<String> personNamesSet = persons.stream().map(p -> p.getName()).collect(Collectors.toSet());
		System.out.println(personNamesSet);
		// will return [Saahas, Rahul, Pankaj, Saurabh] - will remove duplicates

		// ************* Grouping and counting ******************
		// ********* To prepare map with key as Person's name and value as count of person with that name ********
		Map<String, Long> personNameWithCountMap = persons.stream()
				.collect(Collectors.groupingBy(Person::getName, Collectors.counting()));
		System.out.println(personNameWithCountMap);
		// Will return {Rahul=2, Saahas=1, Pankaj=1, Saurabh=1}

		// ****************** To prepare map with key as Person's age and value as count of person with that age ******************
		Map<Integer, Long> personAgeWithCountMap = persons.stream()
				.collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
		System.out.println(personAgeWithCountMap);
		// Will return {32=1, 33=2, 31=1}
		
		// ************ Grouping mapping and collecting in an immutable map
		Map<Integer, List<Person>> unmodifiableMap = persons.stream().collect(
							Collectors.collectingAndThen(Collectors.groupingBy(Person::getAge), Collections::unmodifiableMap));
		System.out.println(unmodifiableMap);
		// Will return {32=[Person [age=32, name=Pankaj]], 33=[Person [age=33, name=Saahas], Person [age=33, name=Rahul]], 66=[Person [age=66, name=Rahul]], 31=[Person [age=31, name=Saurabh]]}

		

	}
}
