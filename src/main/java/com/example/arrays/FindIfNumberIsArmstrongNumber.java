package com.example.arrays;

import java.util.Scanner;

public class FindIfNumberIsArmstrongNumber {

	public static void main(String[] args) {
		System.out.println("Enter a 3-digit number to check if it is an Armstrong number: ");
		@SuppressWarnings("resource")
		int number = new Scanner(System.in).nextInt();
		
		if(isArmstrong(number)) {
			System.out.println("Given number is an Armstrong number. ");
		} else {
			System.out.println("Given number is not an Armstrong number. ");
		}
	}

	private static boolean isArmstrong(int number) {
		int result = 0;
		int original = number;
		
		while(number != 0) {
			int remainder = number % 10;
			result += remainder*remainder*remainder;
			number = number / 10;
		}
		if(original == result) {
			return true;
		} else {
			return false;
		}
	}
}
