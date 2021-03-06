package com.example.booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task2Solution {

	public static void main(String[] args) {
		List<Integer> hotelIds = new ArrayList<Integer>();
		hotelIds.add(1);
		hotelIds.add(2);
		hotelIds.add(1);
		hotelIds.add(1);
		hotelIds.add(2);

		String positiveKeywords = "breakfast beach citycenter location metro view staff price";
		String negativeKeywords = "not";

		List<String> reviews = new ArrayList<>();
		reviews.add("This hotel has a nice view of the citycenter. The location is perfect");
		reviews.add(
				"The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth");
		reviews.add(
				"Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.");
		reviews.add("They said I couldnt take my dog and there were other guests with dogs! That is not fair.");
		reviews.add("very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.");

		int k = 2;

		awardTopKHotels(positiveKeywords, negativeKeywords, hotelIds, reviews, k).forEach(System.out::println);
	}

	public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords,
			List<Integer> hotelIds, List<String> reviews, int k) {

		List<String> positiveKeywordList = Arrays.asList(positiveKeywords.split(" "));
		List<String> negativeKeywordsList = Arrays.asList(negativeKeywords.split(" "));
		Map<Integer, Integer> scoresMap = new LinkedHashMap<>();

		for (int i = 0; i < hotelIds.size(); i++) {
			int hotelId = hotelIds.get(i);
			int score = 0;

			List<String> wordsInIndividualReview = Arrays.asList(reviews.get(i).split(" "));
			wordsInIndividualReview = wordsInIndividualReview.stream().map(s -> s.replaceAll("\\.+$", ""))
					.collect(Collectors.toList());
			wordsInIndividualReview = wordsInIndividualReview.stream().map(s -> s.replaceAll("\\,+$", ""))
					.collect(Collectors.toList());

			for (String reviewWord : wordsInIndividualReview) {
				if (positiveKeywordList.contains(reviewWord)) {
					score += 3;
				}
				if (negativeKeywordsList.contains(reviewWord)) {
					score = score - 1;
				}
			}

			if (scoresMap.containsKey(hotelId)) {
				scoresMap.put(hotelId, scoresMap.get(hotelId) + score);
			} else {
				scoresMap.put(hotelId, score);
			}
		}

		// now let's sort the map in decreasing order of value
		List<Integer> collect = scoresMap.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.map(e -> e.getKey())
				.collect(Collectors.toList());

		return collect;
	}
}
