package com.learnJava.streams_terminal;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

public class StreamsMappingExample_2 {

	public static void main(String[] args) {
		// 1.
		List<String> studentNamesList = StudentDataBase.getAllStudents().stream()
				.collect(Collectors.mapping(Student::getName, Collectors.toList()));
		System.out.println(studentNamesList);

		// 2.
		Set<String> studentNamesSet = StudentDataBase.getAllStudents().stream()
				.collect(Collectors.mapping(Student::getName, Collectors.toSet()));
		
		// Below operation is same as above in 2
		// StudentDataBase.getAllStudents().stream().map(Student::getName).collect(Collectors.toSet());
		
		System.out.println(studentNamesSet);
	}

}
