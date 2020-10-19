package com.main.javaindepth;

public class Book {

	public static void main(String[] args) {
		for (BookGenre genre : BookGenre.values()) {
			System.out.println("Name: " + genre);
			System.out.println("name() : " + genre.name());
			System.out.println("ordinal: " + genre.ordinal());
			System.out.println("Declaring class: " + genre.getDeclaringClass());
			System.out.println("compareTo(HORROR): " + genre.compareTo(BookGenre.HORROR));
			System.out.println("equals(HORROR): " + genre.equals(BookGenre.HORROR));
			System.out.println("getMinAgeToRead" + genre.getMinAgeToRead());
			System.out.println("====================");
		}
	}

	public enum BookGenre {

		BIOGRAPHY(12), HORROR(15);

		private BookGenre() {
			// TODO Auto-generated constructor stub
		}

		private BookGenre(int minAgeToRead) {
			this.minAgeToRead = minAgeToRead;
		}

		private int minAgeToRead;

		public int getMinAgeToRead() {
			return minAgeToRead;
		}
	}
}