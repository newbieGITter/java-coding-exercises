package com.learnJava.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

public class StreamsReduceExample_2 {
	
	public static int performMultiplication(List<Integer> integerList) {
		return integerList.stream().reduce(1, (a,b) -> a*b);
	}
	
	public static Optional<Integer> performMultiplicationWithoutIdentity(List<Integer> integerList) {
		return integerList.stream().reduce((a,b) -> a*b);
	}
	
	public static Optional<Student> getHighestGradeStudent() {
		return StudentDataBase.getAllStudents().stream().reduce((s1, s2) -> (s1.getGpa() > s2.getGpa() ? s1: s2));
	}
	
	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 3, 5, 7);
		
		System.out.println("Result is : " + performMultiplication(integers));
        Optional<Integer> result = performMultiplicationWithoutIdentity(integers);

        if(result.isPresent()){
            System.out.println("Result is : " +result.get());
        }else{
            System.out.println("Result is : " +0);
        }
        
       // System.out.println(combineStudentNames());
        System.out.println(getHighestGradeStudent().get());
	}

}
