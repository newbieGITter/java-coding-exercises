package com.example.regex;

import java.math.BigInteger;
import java.nio.ByteBuffer;

public class RemovingDuplicateWordsInStringDemo {

	public static void main(String[] args) {
//		5 -- number of line of string
//		Goodbye bye bye world world world
//		Sam went went to to to his business
//		Reya is is the the best player in eye eye game
//		in inthe
//		Hello hello Ab aB
		String n = "2";
		BigInteger bi = new BigInteger(n);
		System.out.println(bi.nextProbablePrime());
		
		if (bi.isProbablePrime(2)) {
			System.out.println("prime");
		} else {
			System.out.println("not prime");
		}
	}

}
