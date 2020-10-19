package com.example.codility;

public class ZalandoTaskOne {

	public static void main(String[] args) {
		System.out.println("Number is: "+ solution(1990));
	}

	private static int solution(int N) {
		int sumOfDigitsInNumber = getSumOfDigitsInNumber(N);
		boolean found = true;
		int nextNum = N;
		
		while (found) {
			nextNum = nextNum+1;
			int tempSum = getSumOfDigitsInNumber(nextNum);

			if (sumOfDigitsInNumber == tempSum) {
				return nextNum;
			}
		}
		return 0;
	}

	private static int getSumOfDigitsInNumber(int N) {
		int m = 0, sum = 0;
		while (N > 0) {
			m = N % 10;
			sum = sum + m;
			N = N / 10;
		}
		return sum;
	}

}
