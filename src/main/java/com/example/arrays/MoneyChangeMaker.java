package com.example.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoneyChangeMaker {

	private static final Logger logger = LoggerFactory.getLogger(MoneyChangeMaker.class);

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Reading data using readLine
		// 0.50:100 1.00:200 2.50:200  - -stateDescription in value:quantity
		// 4 --nr of transactions
		// amount1 -- 14.50
		// amount2 -- 12.50
		// amount3 -- 20.00
		// amount4 -- 5.25 
		String stateDescription = reader.readLine();
		String[] stateDescriptionSetup = stateDescription.split(" ");
		int nrOfTransactions = Integer.parseInt(reader.readLine());

		Map<Integer, Float> amountMap = new HashMap<>();
		for (int i = 0; i < nrOfTransactions; i++) {
			float amount = Float.parseFloat(reader.readLine());
			amountMap.put(i, amount);
		}

		validateStateDescriptionSetup(stateDescriptionSetup);
		validateNrOfTransaction(nrOfTransactions);
		validateAmounts(nrOfTransactions, amountMap);

		Arrays.stream(stateDescriptionSetup).forEach(s -> System.out.println(s));
		System.out.println("Nr of transactions: " + nrOfTransactions);
	}

	private static void validateAmounts(int nrOfTransactions, Map<Integer, Float> amountMap) {
		if (nrOfTransactions != amountMap.size()) {
			logger.error("Amounts should be equals to number of transactions value");
		}
	}

	private static void validateStateDescriptionSetup(String[] stateDescriptionSetup) {
		if (stateDescriptionSetup.length < 3 || stateDescriptionSetup.length > 10) {
			logger.error("State description slot should be between 3 and 10");
		}
	}

	private static void validateNrOfTransaction(int nrOfTransactions) {
		if (nrOfTransactions <= 0 || nrOfTransactions > 1000) {
			logger.error("Nr of Transactions should be between 1 and 1000");
		} 
	}

}
