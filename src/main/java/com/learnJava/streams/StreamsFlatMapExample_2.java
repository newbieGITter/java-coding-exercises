package com.learnJava.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

public class StreamsFlatMapExample_2 {

	public static List<String> printStudentActivities() {
		List<String> studentActivites = StudentDataBase.getAllStudents().stream() // Stream<Student
				.map(Student::getActivities) // Stream<List<String>>
				.flatMap(List::stream) // Stream<String
				.collect(Collectors.toList());
		return studentActivites;
	}

	public static List<String> printUniqueStudentActivites() {
		return StudentDataBase.getAllStudents().stream()
							  .map(Student::getActivities)
							  .flatMap(List::stream)
							  .distinct()
							  //.sorted() // Will sort by natural order
							  .sorted(Comparator.reverseOrder()) // will sort by reverse order
							  .collect(Collectors.toList());
	}

	public static long getStudentActivitesCount() {
		return StudentDataBase.getAllStudents().stream().map(Student::getActivities).flatMap(List::stream).distinct()
				.count();
	}

	public static void main(String[] args) {
		System.out.println("Student activities: " + printStudentActivities());
		System.out.println("Unique Student activities:" + printUniqueStudentActivites());
		System.out.println("Count of Unique Student activities:" + getStudentActivitesCount());
	}
}
