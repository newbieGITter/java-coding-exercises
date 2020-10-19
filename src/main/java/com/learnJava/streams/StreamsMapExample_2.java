package com.learnJava.streams;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

public class StreamsMapExample_2 {

	public static List<String> namesList() {
		List<String> students = StudentDataBase.getAllStudents().stream() // Stream<Student>
				.map(Student::getName) // Stream<String>
				.map(String::toUpperCase) // Stream<String -> it performs uppercase operation on each input
				.collect(Collectors.toList());
		return students;
	}

	public static Set<String> namesSet() {
		Set<String> students = StudentDataBase.getAllStudents().stream() // Stream<Student>
				.map(Student::getName) // Stream<String>
				.map(String::toUpperCase) // Stream<String -> it performs uppercase operation on each input
				.collect(Collectors.toSet());
		return students;
	}

	public static void main(String[] args) {
		System.out.println(namesList());
		System.out.println(namesSet());
	}
}
