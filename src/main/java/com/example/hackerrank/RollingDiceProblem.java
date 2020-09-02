package com.example.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RollingDiceProblem {

	private static Map<Integer, Integer> move2Count = new HashMap<>();
	static {
		move2Count.put(1, 6);
		move2Count.put(2, 4);
		move2Count.put(3, 5);
		move2Count.put(4, 2);
		move2Count.put(5, 3);
		move2Count.put(6, 1);
	}

	public static void main(String[] args) {
		String msg = null;
		msg = String.format("expected : %s actual: %s ", 2, solution(Arrays.asList(1, 2, 3)));
		System.out.println(msg);
		msg = String.format("expected : %s actual: %s ", 2, solution(Arrays.asList(1, 1, 6)));
		System.out.println(msg);
		msg = String.format("expected : %s actual: %s ", 3, solution(Arrays.asList(1, 6, 2, 3)));
		System.out.println(msg);
	}

	private static int solution(List<Integer> list) {
		int moveCount = 0;
		final int pivot = getPivot(list);
		for (final Integer curElement : list) {
			if (pivot != curElement) {
				if (move2Count.get(curElement) == pivot) {
					moveCount += 2;
				} else {
					moveCount++;
				}
			}
		}
		return moveCount;

	}

	private static Integer getPivot(List<Integer> list) {
		int pivot = list.get(0);
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				final Integer curElement = list.get(i);
				final Integer nextElement = list.get(j);

				if (move2Count.get(curElement) != nextElement) {
					pivot = curElement;
				}
			}
		}
		return pivot;
	}
}
