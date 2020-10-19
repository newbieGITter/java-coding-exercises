package com.learnJava.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

public class StreamsComparatorExample_2 {
	
	public static List<Student> sortStudentsByName() {
		return StudentDataBase.getAllStudents().stream()	
						.sorted(Comparator.comparing(Student::getName))
						.collect(Collectors.toList());
	}
	
	public static List<Student> sortStudentsByGpa() {
		return StudentDataBase.getAllStudents().stream()
						.sorted(Comparator.comparing(Student::getGpa))
						.collect(Collectors.toList());
	}
	
	public static List<Student> sortStudentsByGpaDescending() {
		return StudentDataBase.getAllStudents().stream()
						.sorted(Comparator.comparing(Student::getGpa).reversed())
						.collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		System.out.println("Sort students by Name: ");
		sortStudentsByName().forEach(System.out::println);
		
		System.out.println(" +++++++++++++++++++++++++ ");
		System.out.println("Sort students by Gpa: ");
		sortStudentsByGpa().forEach(System.out::println);
		
		System.out.println(" +++++++++++++++++++++++++ ");
		System.out.println("Sort students by Gpa Descending: ");
		sortStudentsByGpaDescending().forEach(System.out::println);
		
	}

}
