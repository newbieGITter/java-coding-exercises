package com.example.streams;

public class User {

	private String name;
	private int age;

	public User() {
	}

	public User(String name) {
		super();
		this.name = name;
		
		// Some random logic to assign age
		if(name.startsWith("S")) {
			this.age = 30;
		} else {
			this.age = 35;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
