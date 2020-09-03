package com.example.hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class JavaEndOfFileDemo {
	
	// Sample Input:
	// Hello World
	// This is Java
	// I am a Java Developer
	
	// Sample output:
	// 1 Hello World
	// 2 This is Java
	// 3 I am a Java Developer
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		for (int j = 1;; j++) {
			if (scan.hasNext()) {
				System.out.println(j + " " + scan.nextLine());
			} else {
				break;
			}
		}
		scan.close();

		// Scanner scan = new Scanner(System.in);
		// int i = 0;
		// Map<Integer, String> map = new LinkedHashMap<>();
		//
		// while (scan.hasNext()) {
		// i++;
		// map.put(++i, scan.nextLine());
		// }
		//
		// map.entrySet().forEach(System.out::println);
	}

}
