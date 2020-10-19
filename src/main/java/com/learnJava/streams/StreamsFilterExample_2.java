package com.learnJava.streams;

import java.util.List;
import java.util.stream.Collectors;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

public class StreamsFilterExample_2 {

	public static List<Student> filterStudents() {
		return StudentDataBase.getAllStudents().stream().filter(stu -> stu.getGender().equalsIgnoreCase("female"))
				.collect(Collectors.toList());

	}

	public static void main(String[] args) {
		filterStudents().forEach(System.out::println);
	}
}
