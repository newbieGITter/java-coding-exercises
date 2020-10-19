package com.learnJava.streams_terminal;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

public class StreamsMinByMaxByExample_2 {

	private static Optional<Student> minBy(){
		// Will return student with least GPA
		return StudentDataBase.getAllStudents().stream().collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));
	}
	
	private static Optional<Student> maxBy(){
		// Will return student with least GPA
		return StudentDataBase.getAllStudents().stream().collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));
	}
	
	public static void main(String[] args) {
		System.out.println("Student with least GPA: " + minBy());
		System.out.println("Student with least GPA: " + maxBy());
	}
}
