package com.learnJava.streams;

import com.learnJava.data.StudentDataBase;

public class StreamsMatchExample_2 {

	private static boolean allMatch() {
		return StudentDataBase.getAllStudents().stream().allMatch(stu -> stu.getGpa() >= 3.5);
	}

	private static boolean anyMatch() {
		return StudentDataBase.getAllStudents().stream().anyMatch(stu -> stu.getGpa() > 4.0);
	}

	private static boolean noneMatch() {
		return StudentDataBase.getAllStudents().stream().noneMatch(stu -> stu.getGpa() == 4.0);
	}

	public static void main(String[] args) {
		System.out.println("Result of allMatch: " + allMatch());
		System.out.println("Result of anyMatch: " + anyMatch());
		System.out.println("Result of noneMatch: " + noneMatch());
	}

}
