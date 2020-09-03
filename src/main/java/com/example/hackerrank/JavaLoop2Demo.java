package com.example.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaLoop2Demo {
//	For input: 5 3 5 (a b n)
//	5 + 1 * 3 = 8
//	5 + 1 * 3 + 2 * 3 = 14 
//	5 + 1 * 3 + ((2*1) * 3) + ((2*2) * 3) = 14
//	& so on...
//	Output: 8 14 26 50 98
		
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Reading data using readLine
		int nrOfTestCases = Integer.parseInt(reader.readLine());
		Map<Integer, List<String>> inputMap = new HashMap<>();

		for (int i = 0; i < nrOfTestCases; i++) {
			String numbers = reader.readLine().trim();
			inputMap.put(Integer.valueOf(i), Stream.of(numbers.split(" ")).collect(Collectors.toList()));
		}

		inputMap.forEach((k, v) -> {
			System.out.println(" ");
			List<String> values = v;
			int a = Integer.valueOf(values.get(0));
			int b = Integer.valueOf(values.get(1));
			int n = Integer.valueOf(values.get(2));

			double result = a;

			for (int i = 0; i < n; i++) {
				result = result + (Math.pow(2, i) * b);
				System.out.print(Math.round(result) + " ");
			}
		});

	}

}
