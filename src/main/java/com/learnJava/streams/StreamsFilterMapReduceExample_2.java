package com.learnJava.streams;

import java.util.Optional;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

public class StreamsFilterMapReduceExample_2 {

	private static Optional<Integer> getNumberOfNotebooks() {
		return StudentDataBase.getAllStudents().stream()	 // Stream<Student>
										//.filter(stu -> stu.getGradeLevel() >= 3)
										//.filter(stu -> stu.getGender().equalsIgnoreCase("female"))    // We can add filters also to filter the stream
										.map(Student::getNoteBooks)  // Stream<Integer>
										//.reduce((a,b) -> a+b);
										.reduce(Integer::sum); // Another way to add nr of notebooks
	}
	public static void main(String[] args) {
		System.out.println(getNumberOfNotebooks().get());
	}
}
