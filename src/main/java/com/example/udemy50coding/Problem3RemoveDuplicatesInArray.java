package com.example.udemy50coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem3RemoveDuplicatesInArray {

	public static void main(String[] args) {
		int[] A = new int[]{3, 2, 4, 2, 5, 6, 5, 7, 8, 7};
		
		bruteForceSolution(A);
		usingSorting(A);
		usingMap(A);
	}

	// Time complexity: O(n)
	// Space complexity: O(n)
	private static int[] usingMap(int[] a) {
		Map<Integer, Boolean> visited = new HashMap<>();
		
		for(int num: a) {
			if(!visited.containsKey(num)) {
				visited.put(num, true);
			}
		}
		visited.forEach((k, v) -> System.out.print(k + ","));
		return visited.keySet().stream().mapToInt(i -> i).toArray();
	}

	// Time complexity: O(nlogn)
	// Space complexity: O(n)
	private static int[] usingSorting(int[] a) {
		if(a.length == 0) {
			System.out.println("Array is empty.");
		}
		
		Arrays.sort(a);
		List<Integer> list = new ArrayList<>();
		list.add(a[0]);
		
		for(int i = 1; i < a.length; i++) {
			if(a[i] != a[i-1]) {
				list.add(a[i]);
			}
		}
		System.out.println(list);
		return list.stream().mapToInt(i -> i).toArray();
	}

	// Time complexity: O(n²)
	// Space complexity: O(n)
	private static int[] bruteForceSolution(int[] a) {
		List<Integer> list = new ArrayList<>();
		
		for(int num: a) {
			if(!list.contains(num)) {
				list.add(num);
			}
		}
		System.out.println(list);
		return list.stream().mapToInt(i -> i).toArray();
	}
	
	

}
