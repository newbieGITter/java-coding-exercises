package com.example.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class OutputFormattingDemo {
	
	// Sample Input:
	//java 100
	//cpp 65
	//python 50
	
	//Sample output
	//================================
	//java           100 
	//cpp            065 
	//python         050 
	//================================

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> map = new LinkedHashMap<>();
		
		for(int i = 0; i < 3; i++){
			String line1 = reader.readLine().trim();
			String[] splitStr = line1.split(" ");
			map.put(splitStr[0], Integer.parseInt(splitStr[1]));
		}
		
		System.out.println("================================");
		map.forEach((k, v) -> {
			System.out.printf("%-15s %03d", k, v); 
			System.out.println();
		});
		System.out.println("================================");

	}

}
