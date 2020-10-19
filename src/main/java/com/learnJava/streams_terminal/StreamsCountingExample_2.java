package com.learnJava.streams_terminal;

import java.util.stream.Collectors;

import com.learnJava.data.StudentDataBase;

public class StreamsCountingExample_2 {

	private static long count() {
		return StudentDataBase.getAllStudents().stream()
						.filter(stu -> stu.getGpa() > 3.9)
						.collect(Collectors.counting());
	}
	
	
	public static void main(String[] args) {
		System.out.println(count());
	}
}
