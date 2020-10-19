package com.example.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZalandoTaskTwo {
	public static void main(String[] args) {
		//int[] A = new int[] {4, -1, 0,3};
		//int[] B = new int[] {-2, 5, 0, 3};
		
		//int[] A = new int[] {2, -2, -3 ,3};
		//int[] B = new int[] {0, 0, 4, -4}; // 2
		
		//int[] A = new int[] {4, -1, 0, 3};
		//int[] B = new int[] {-2, 6, 0, 4}; // 0
		
		int[] A = new int[] {3, 2, 6};
		int[] B = new int[] {4, 1, 6}; // actually should return 2
		
		//int[] A = new int[] {1, 4, 2, -2, 5};
		//int[] B = new int[] {7, -2, -2, 2, 5}; // actually should return 2
		System.out.println("Fair index:" + solution(A, B));
		
	}
	
	private static int solution(int[] a, int[] b) {
		long sumFirstPart_arrA = 0;
		long sumSecondPart_arrA = 0;
		long sumFirstPart_arrB = 0;
		long sumSecondPart_arrB = 0;
		List<Integer> fairIndexes = new ArrayList<>();

		for (int i = 0, j = 0; i < a.length-1 && j < b.length-1; i++, j++) {
			int sumOfAllElements_arrA = Arrays.stream(a).sum();
			sumFirstPart_arrA += a[i];
			sumSecondPart_arrA = sumOfAllElements_arrA - sumFirstPart_arrA;
			
			int sumOfAllElements_arrB = Arrays.stream(b).sum();
			sumFirstPart_arrB += b[i];
			sumSecondPart_arrB = sumOfAllElements_arrB - sumFirstPart_arrB;

			if(sumFirstPart_arrA == sumFirstPart_arrB && sumSecondPart_arrA == sumSecondPart_arrB) {
				fairIndexes.add(i+1);
			}
		}
		return fairIndexes.size();
	}
//
//	private static void solution(int[] a, int[] b) {
//		for(int i = 0, j = 0; i < a.length && j < b.length; i++, j++) {
//			if(a[i] == b[j]) {
//				int subArrayASum = 0;
//				int subArrayBSum = 0;
//				for(int k = i+1; k < a.length-i; k++) {
//					subArrayASum = subArrayASum + a[k];
//					subArrayBSum = subArrayBSum + b[k];
//				}
//				
//				if(subArrayASum == subArrayBSum) {
//					
//				}
//			}
//
//		}
//	}

}
