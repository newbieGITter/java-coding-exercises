package com.example.udemy50coding;

public class Problem19PathsInMatrix {

	public static void main(String[] args) {
		
	}
	
	// 1. By using recursion:
	// Time complexity: O(2^(n*m))
	// Space complexity: O(n + m)
	static int paths_usingRecursion(int[][] matrix) {
		return paths(matrix, 0, 0);
	}
	
	static int paths(int[][] matrix, int i, int j) {
		int n = matrix.length;
		int m = matrix[0].length;
		
		if(i > n-1 || j > m-1 || matrix[i][j] == 1) {
			return 0;
		}
		else if(i == n-1 && j == m-1) {
			return 1;
		} 
		else {
			return paths(matrix, i+1, j) + paths(matrix, i, j+1);
		}
	}
	
	// 2. Using Dynamic programming
	static int paths_dp(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		
		int[][] dp = new int[n][m];
		dp[0][0] = matrix[0][0] == 1? 0 : 1;
		
		for(int i = 1; i < m; i++) {
			if(matrix[0][i] == 1) {
				dp[0][i] = 0;
			}
			else {
				dp[0][i] = dp[0][i-1];
			}
		}
		
		for(int i = 1; i < n; i++) {
			if(matrix[i][0] == 1) {
				dp[i][0] = 0;
			} else {
				dp[i][0] = dp[i-1][0];
			}
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 1; j < m; j++) {
				if(matrix[i][j] == 1 ) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = dp[i-1][j] + dp[i][j+1];
				}
			}
		}
		return dp[n-1][m-1];
	}
}

