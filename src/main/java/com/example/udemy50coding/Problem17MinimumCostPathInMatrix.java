package com.example.udemy50coding;

public class Problem17MinimumCostPathInMatrix {

	public static void main(String[] args) {

	}

	// Solution 1
	// Using recursion
	// Time complexity: O(2^(n*m))
	// Space complexity: O(n + m)
	static int minimumCostPath_solution1(int[][] matrix) {
		return minimumCostPath(matrix, 0, 0);
	}

	static int minimumCostPath(int[][] matrix, int i, int j) {
		int n = matrix.length;
		int m = matrix[0].length;

		if (i == n - 1 && j == m - 1) {
			return matrix[i][j];
		} else if (i == n - 1) {
			return matrix[i][j] + minimumCostPath(matrix, i, j + 1);
		} else if (j == m - 1) {
			return matrix[i][j] + minimumCostPath(matrix, i + 1, j);
		} else {
			return matrix[i][j] + Math.min(minimumCostPath(matrix, i + 1, j), minimumCostPath(matrix, i, j + 1));
		}
	}

	// Solution 2
	// By using dynamic programming:
	// Time complexity: O(n*m)
	// Space complexity: O(n*m)
	static int minimumCostPath_solution2(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;

		int[][] costs = new int[n][m];
		costs[0][0] = matrix[0][0];

		for (int i = 1; i < m; i++) {
			costs[0][i] = costs[0][i - 1] + matrix[0][i];
		}

		for (int i = 1; i < n; i++) {
			costs[i][0] = costs[i - 1][0] + matrix[i][0];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				costs[i][j] = matrix[i][j] + Math.min(costs[i - 1][j], costs[i][j - 1]);
			}
		}
		return costs[n - 1][m - 1];
	}

}
