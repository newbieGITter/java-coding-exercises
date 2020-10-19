package com.main.javaindepth;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;

public class NewDateAndTimeDemo {

	public static void main(String[] args) {
		Instant startTime = Instant.now();
		testDateTimeApi();
		
		Instant endTime = Instant.now();
		Duration timeElapsed = Duration.between(startTime, endTime);
		System.out.println("Time elapsed: {} " + timeElapsed);
	}
	
	public static void testDateTimeApi() {

		
		LocalDate expiryDate = LocalDate.of(2017, Month.JUNE, 30);
		System.out.println("expiryDate: {}" + expiryDate);
		
		LocalDate expiryPlusEightMonths = expiryDate.plusMonths(8);
		System.out.println("expiryPlusEightMonths: " + expiryPlusEightMonths);
		
		System.out.println("Year: " + expiryDate.getYear());
		System.out.println("Month: " + expiryDate.getMonth());
		
		System.out.println("Year again: " + expiryDate.get(ChronoField.YEAR));
		System.out.println("Month again: " + expiryDate.get(ChronoField.MONTH_OF_YEAR));
		System.out.println("day of month again: " + expiryDate.get(ChronoField.DAY_OF_MONTH));
		
		System.out.println("Day of month: " + expiryDate.getDayOfMonth());
		System.out.println("Day of week: " + expiryDate.getDayOfWeek());
		System.out.println("Length of month: " + expiryDate.lengthOfMonth());
		System.out.println("Is Leap year: " + expiryDate.isLeapYear());
		
		// Forming LocalDateTime using LocalDate and LocalTime
		LocalDate localDate = LocalDate.of(2019, Month.APRIL, 25);
		
		LocalTime localTime = LocalTime.of(5, 35);
		System.out.println("time hour: " + localTime.getHour());
		System.out.println("time min: " + localTime.getMinute());
		
		// LocalDateTime
		LocalDateTime gameStartDateTime = LocalDateTime.of(localDate, localTime);
		System.out.println("gameStartTime: " +  gameStartDateTime) ;
		
		// Date, time and timezone together in ZonedDateTime
		ZonedDateTime zonedGameStartTime = ZonedDateTime.of(localDate, localTime, ZoneId.of("CET"));
		System.out.println("zonedGameStartTime: " + zonedGameStartTime);
		
		ZonedDateTime indiaTime = zonedGameStartTime.withZoneSameInstant(ZoneId.of("Asia/Kolkata"));
		System.out.println("India Time: " + indiaTime);
		
		// Age calculation
		System.out.println(" ======== Age Calculation ======== ");
		LocalDate birthday = LocalDate.of(1978, Month.JANUARY, 1);
		LocalDate today = LocalDate.now();
		Period period = birthday.until(today);
		System.out.println("Complete age: " + period.toString());
		System.out.println("Age: " + period.getYears());
	}

}
