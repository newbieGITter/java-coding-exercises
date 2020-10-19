package com.learnJava.streams_terminal;

import java.util.stream.Collectors;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

public class StreamsJoiningExample_2 {

	private static String joining_1() {
		return StudentDataBase.getAllStudents().stream()		
						.map(Student::getName)
						.collect(Collectors.joining());
	}
	
	private static String joining_2() {
		return StudentDataBase.getAllStudents().stream()		
						.map(Student::getName)
						.collect(Collectors.joining(","));
	}
	
	private static String joining_3() {
		return StudentDataBase.getAllStudents().stream()		
						.map(Student::getName)
						.collect(Collectors.joining("-", "(", ")"));
	}
	
	public static void main(String[] args) {
		System.out.println("joining_1: " + joining_1());
		System.out.println("joining_2: " + joining_2());
		System.out.println("joining_3: " + joining_3());
	}
}
