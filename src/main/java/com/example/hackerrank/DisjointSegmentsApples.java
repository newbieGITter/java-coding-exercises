package com.example.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DisjointSegmentsApples {
	public static int solution(int[] A, int K, int L) {
		int N = A.length;
		
		// Validate N
		if(N < 2 && N > 600){
			return -1;
		}
		
		// validate K & L values
		if(K < 1 || K > N-1 || L < 1 || L > N-1){
			return -1;
		}
		
		// validate each element in the integer array
		if(Arrays.stream(A).boxed().filter(n -> n < 1 || n > 500).count() > 0) {
			return -1;
		}
		
		// General validation
		if(K + L > N){
			return -1;
		}
		
		List<Integer> al = Arrays.stream(A).boxed().collect(Collectors.toList());
		
		int max_K = 0;
		int k_position = 0;
		for(int i = 0; i <= N-K; i++){
			int sumOfKNumbers = al.subList(i, i+K).stream().mapToInt(Integer::intValue).sum();
			if(sumOfKNumbers > max_K){
				max_K = sumOfKNumbers;
				k_position = i;
			}
		}
		
		int max_L = 0;
		int l_position = 0;
		
		if(k_position+K+1 < N){
			for(int i = k_position+K+1; i <= N-L; i++){
				int sumOfLNumbers = al.subList(i, i+L).stream().mapToInt(Integer::intValue).sum();
				if(sumOfLNumbers > max_L){
					max_L = sumOfLNumbers;
					l_position = i;
				}
			}	
		} else if(l_position+1 < k_position){
			for(int i = 0; i <= k_position-L-1; i++){
				int sumOfLNumbers = al.subList(i, i+L).stream().mapToInt(Integer::intValue).sum();
				if(sumOfLNumbers > max_L){
					max_L = sumOfLNumbers;
					l_position = i;
				}
			}
		}
		System.out.println("Final: " + max_K + ", " + max_L);
		System.out.println("Final: " + k_position + ", " + l_position);
		
		if ((l_position >= k_position+K+1) || (k_position >= l_position+L+1)){
			return max_K + max_L;
		}
		
		return -1;
		
	}
	
	public static void main(String[] args) {
		//int[] arr = {6, 1, 4, 6, 3, 2, 7, 4};
		//int[] arr = {10, 15, 9, 21, 10, 11, 22};
		int[] arr = {10, 15, 9, 10, 11};
		System.out.println(solution(arr, 2, 2));
	}
}
