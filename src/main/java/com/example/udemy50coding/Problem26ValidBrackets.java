package com.example.udemy50coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Problem26ValidBrackets {

	public static void main(String[] args) {
		System.out.println("String valid check: " + isValid("{([({)}])}"));
		//Input : {([({)}])} ; output : false
		//Input : {([({)])} ; output : false
		//Input : {([({})])} ; output : true
		//Input : {([])} ; output : true
	}

	// Time complexity: O(n)
	// Space complexity: O(n)
	static boolean isValid(String str) {
		Map<Character, Character> bracketsMap = new HashMap<>();
		bracketsMap.put('(', ')');
		bracketsMap.put('[', ']');
		bracketsMap.put('{', '}');

		List<Character> openingBrackets = Arrays.asList('(', '[', '{');
		Stack<Character> stack = new Stack<>();

		for (char bracket : str.toCharArray()) {
			if (openingBrackets.contains(bracket)) {
				stack.push(bracket);
			} else if (stack.size() > 0 && bracket == bracketsMap.get(stack.peek())) {
				stack.pop();
			} else {
				return false;
			}
		}
		return stack.isEmpty();
	}

}
