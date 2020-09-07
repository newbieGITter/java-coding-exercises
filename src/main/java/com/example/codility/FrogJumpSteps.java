package com.example.codility;

public class FrogJumpSteps {
	public static void main(String[] args) {
		int[] A = new int[] { 10, 85, 30 };
		System.out.println("Jumps required: " + solution(A[0], A[1], A[2]));
	}

	private static int solution(int X, int Y, int D) {
		int distanceToJump = Y - X;
		int jumpsRequired = distanceToJump / D;
		
		if(distanceToJump % D != 0) {
			jumpsRequired++;
		}
		return jumpsRequired;
	}
}
