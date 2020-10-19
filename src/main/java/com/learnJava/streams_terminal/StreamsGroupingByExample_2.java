package com.learnJava.streams_terminal;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

public class StreamsGroupingByExample_2 {

	private static Map<String, List<Student>> groupingStudentsByGender() {
		return StudentDataBase.getAllStudents().stream().collect(Collectors.groupingBy(Student::getGender));
	}

	private static void customizedGroupingBy() {
		Map<String, List<Student>> studentsMap = StudentDataBase.getAllStudents().stream()
				.collect(Collectors.groupingBy(stu -> stu.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE"));
		System.out.println(studentsMap);
	}

	// To get a map with key as Grade Level and value as another map with key as
	// "outstanding"/"average? based on Gpa score
	private static void twoLevelGrouping_1() {
		Map<Integer, Map<String, List<Student>>> twoLevelStudentMap = StudentDataBase.getAllStudents().stream()
				.collect(Collectors.groupingBy(Student::getGradeLevel,
						Collectors.groupingBy(stu -> stu.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE")));
		System.out.println(twoLevelStudentMap);
	}

	// To get a map with key as Grade Level and value as sum of notebooks for that
	// grade
	private static void twoLevelGrouping_2() {
		Map<Integer, Integer> twoLevelStudentMap = StudentDataBase.getAllStudents().stream()
				.collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.summingInt(Student::getNoteBooks)));
		System.out.println(twoLevelStudentMap);
	}

	private static void twoLevelGrouping_3() {
		Map<String, Integer> twoLevelStudentMap = StudentDataBase.getAllStudents().stream()
				.collect(Collectors.groupingBy(Student::getName, Collectors.summingInt(Student::getNoteBooks)));
		System.out.println(twoLevelStudentMap);
	}

	private static void threeArgumentGroupBy() {
		Map<String, Set<Student>> studentLinkedHashMap = StudentDataBase.getAllStudents().stream()
				.collect(Collectors.groupingBy(Student::getName, LinkedHashMap::new, Collectors.toSet()
				// Collectors.summingInt(Student::getNoteBooks)
				));
		System.out.println(studentLinkedHashMap);
	}

	private static void calculateStudentsWithMaxGpa() {
		Map<Integer, Optional<Student>> studentMapOptional = StudentDataBase.getAllStudents().stream().collect(
				Collectors.groupingBy(Student::getGradeLevel, Collectors.maxBy(Comparator.comparing(Student::getGpa))));
		System.out.println(studentMapOptional);

		Map<Integer, Object> studentMapOptional1 = StudentDataBase.getAllStudents().stream().collect(
				Collectors.groupingBy(Student::getGradeLevel, 
									  Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getGpa)), Optional::get)));
		System.out.println(studentMapOptional1);
	}
	
	private static void calculateStudentWithMinGpa() {
		Map<Integer, Optional<Student>> studentMinOptional = StudentDataBase.getAllStudents().stream()
						.collect(Collectors.groupingBy(Student::getGradeLevel,
								Collectors.minBy(Comparator.comparing(Student::getGpa))));
		System.out.println(studentMinOptional);
		
		Map<Integer, Student> studentMinOptional1 = StudentDataBase.getAllStudents().stream()
						.collect(Collectors.groupingBy(Student::getGradeLevel,
								Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Student::getGpa)), Optional::get)));

		System.out.println(studentMinOptional1);
	}

	public static void main(String[] args) {
		System.out.println(groupingStudentsByGender());
		customizedGroupingBy();
		twoLevelGrouping_1();
		twoLevelGrouping_2();
		twoLevelGrouping_3();
		threeArgumentGroupBy();
		calculateStudentsWithMaxGpa();
		calculateStudentWithMinGpa();
	}
}
