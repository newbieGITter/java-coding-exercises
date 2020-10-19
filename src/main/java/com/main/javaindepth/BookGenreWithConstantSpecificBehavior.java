package com.main.javaindepth;

public enum BookGenreWithConstantSpecificBehavior {

	BIOGRAPHY(12) {
		@Override
		boolean isKidFriendly(int age) {
			return age >= getMinAgeToRead();
		}
	},
	HORROR(15) {
		@Override
		boolean isKidFriendly(int age) {
			return false;
		}
	};

	abstract boolean isKidFriendly(int age);

	private BookGenreWithConstantSpecificBehavior() {
		// TODO Auto-generated constructor stub
	}

	private BookGenreWithConstantSpecificBehavior(int minAgeToRead) {
		this.minAgeToRead = minAgeToRead;
	}

	private int minAgeToRead;

	public int getMinAgeToRead() {
		return minAgeToRead;
	}

}
