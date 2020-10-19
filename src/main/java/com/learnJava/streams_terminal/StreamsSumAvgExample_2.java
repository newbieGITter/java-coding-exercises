package com.learnJava.streams_terminal;

import java.util.stream.Collectors;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

public class StreamsSumAvgExample_2 {

	private static int sum() {
		return StudentDataBase.getAllStudents().stream()
						.collect(Collectors.summingInt(Student::getNoteBooks));
	}
	
	private static Double avg() {
		return StudentDataBase.getAllStudents().stream().collect(Collectors.averagingInt(Student::getNoteBooks));
	}
	
	public static void main(String[] args) {
		System.out.println("Sum of notebooks: " + sum());
		System.out.println("Avg of notebooks: " + avg());
	}
}
