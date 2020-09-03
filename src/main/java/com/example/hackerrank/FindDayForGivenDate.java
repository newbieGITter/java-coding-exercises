package com.example.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class FindDayForGivenDate {
//	Input: 08 05 2015 where 08 is month, 05 is day & 2015 is year
//	Output: WEDNESDAY
//	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int month = Integer.parseInt(firstMultipleInput[0]);

		int day = Integer.parseInt(firstMultipleInput[1]);

		int year = Integer.parseInt(firstMultipleInput[2]);

		String res = FindDayForGivenDate.findDay(month, day, year);
		System.out.println(res);

		// bufferedWriter.write(res);
		// bufferedWriter.newLine();

		bufferedReader.close();
		// bufferedWriter.close();
	}

	public static String findDay(int month, int day, int year) {
		LocalDate date = LocalDate.of(year, month, day);
		DayOfWeek dow = date.getDayOfWeek(); // Extracts a `DayOfWeek` enum
												// object.
		return dow.getDisplayName(TextStyle.FULL, Locale.US).toUpperCase(); // String = Tue
	}
}