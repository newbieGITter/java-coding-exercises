package com.learnJava.streams;

import java.util.Optional;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

public class StreamsFindAnyFirstExample_2 {

	private static Optional<Student> findAny() {
		return StudentDataBase.getAllStudents().stream().filter(stu -> stu.getGpa() >= 3.9).findAny();
	}

	private static Optional<Student> findFirst() {
		return StudentDataBase.getAllStudents().stream().filter(stu -> stu.getGpa() >= 3.9).findFirst();
	}

	public static void main(String[] args) {
		System.out.println("FindAny: " + findAny());
		System.out.println("findFirst: " + findFirst());
	}
}
