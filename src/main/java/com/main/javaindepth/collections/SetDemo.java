package com.main.javaindepth.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		Set<String> set1 = new HashSet<>();
		set1.add("a");
		set1.add("b");
		set1.add("a");

		System.out.println(set1);

		Book book1 = new Book("Walden", "Henry Thoreau", 1854);
		Book book2 = new Book("Walden", "Henry Thoreau", 1854);

		Set<Book> set2 = new HashSet<>();
		set2.add(book1);
		set2.add(book2);
		System.out.println(set2);

		Book book3 = new Book("Harry Potter", "J.K. Rowling", 1997);
		Book book4 = new Book("Harry Potter", "J.K. Rowling", 1997);

		Set<Book> set3 = new TreeSet<>((o1, o2) -> {
			Book b1 = (Book) o1;
			Book b2 = (Book) o2;
			return Integer.valueOf(b1.getYear()).compareTo(Integer.valueOf(b2.getYear()));
		});
		set3.add(book1);
		set3.add(book2);
		set3.add(book3);
		set3.add(book4);
		System.out.println(set3);
	}
}

class Book implements Comparable<Book> {
	private String title;
	private String author;
	private int year;

	public Book(String title, String author, int year) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", year=" + year + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public int compareTo(Book o) {
		return getTitle().compareTo(o.getTitle());

	}

}
