package com.example.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class CountryCount {
	public static void main(String[] args) {
		// @formatter:off
		final int[][] world = new int[][] { { 5, 4, 4 }, { 4, 3, 4 }, { 3, 2, 4 }, { 2, 2, 2 }, { 3, 3, 4 },
				{ 1, 4, 4 }, { 4, 1, 1 }, };
		// @formatter:on

		System.out.println("CountryCount.main() " + solution(world));
	}

	private static Integer solution(int[][] world) {
		//Integer world[][]
		Integer countryCount = 0;
		final List<String> listOfBoundryCountries = new ArrayList<>();
		for (int row = 0; row < world.length; row++) {
			for (int col = 0; col < world[row].length; col++) {
				if (!listOfBoundryCountries.contains(row + "#" + col)) {
					final List<String> listOfNeighbours = getListOfBoundryCountries(row, col, world);
					if (!checkCountryVisitedAlready(listOfNeighbours, listOfBoundryCountries)) {
						countryCount++;
					}
					listOfBoundryCountries.addAll(listOfNeighbours);
				}
			}
		}
		return countryCount;
	}

	private static boolean checkCountryVisitedAlready(List<String> listOfNeighbours,
			List<String> listOfBoundryCountries) {
		for (final String string : listOfNeighbours) {
			if (listOfBoundryCountries.contains(string)) {
				return true;
			}
		}
		return false;
	}

	private static List<String> getListOfBoundryCountries(int row, int col, int[][] world) {
		final List<String> countryString = new ArrayList<>();
		countryString.add(row + "#" + col);
		final Integer pivot = world[row][col];
		if (row - 1 >= 0 && row - 1 < world.length && world[row - 1][col] == pivot) {
			countryString.add(row - 1 + "#" + col);

		}
		if (row + 1 < world.length && world[row + 1][col] == pivot) {
			countryString.add(row + 1 + "#" + col);

		}

		if (col - 1 >= 0 && col - 1 < world[row].length && world[row][col - 1] == pivot) {
			countryString.add(row + "#" + (col - 1));

		}
		if (col + 1 < world[row].length && world[row][col + 1] == pivot) {
			countryString.add(row + "#" + (col + 1));
		}

		return countryString;
	}
}
