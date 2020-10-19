package com.example.udemy50coding;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem31WaysToClimbStairs {

	public static void main(String[] args) {
		System.out.println("Nr of ways to climb stairs: "
				+ nrOfWayToClimb(5, Arrays.asList(1, 3).stream().collect(Collectors.toSet())));
	}

	// By using recursion:
	// Time complexity: O(m^n)
	// Space complexity: O(n)
	static int nrOfWayToClimb(int n, Set<Integer> possibleSteps) {
		if (n == 0)
			return 1;

		int nbWays = 0;

		for (Integer step : possibleSteps) {
			if (n - step >= 0) {
				nbWays += nrOfWayToClimb(n - step, possibleSteps);
			}
		}
		return nbWays;
	}
}
