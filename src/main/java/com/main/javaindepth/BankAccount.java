package com.main.javaindepth;

public class BankAccount {

	private final long accountNumber;
	private final String owner;
	private final String branch;
	private final double balance;

	private BankAccount(Builder builder) {
		this.accountNumber = builder.accountNumber;
		this.owner = builder.owner;
		this.branch = builder.branch;
		this.balance = builder.balance;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public String getOwner() {
		return owner;
	}

	public String getBranch() {
		return branch;
	}

	public double getBalance() {
		return balance;
	}

	public static class Builder {
		private long accountNumber;
		private String owner;
		private String branch;
		private double balance;

		public Builder(long accountNumber) {
			this.accountNumber = accountNumber;
		}

		public Builder withOwner(String owner) {
			this.owner = owner;

			return this;
		}

		public Builder atBranch(String branch) {
			this.branch = branch;

			return this;
		}

		public Builder initialBalance(double balance) {
			this.balance = balance;
			return this;
		}

		public BankAccount build() {
			BankAccount account = new BankAccount(this);
			return account;
		}

	}

}
