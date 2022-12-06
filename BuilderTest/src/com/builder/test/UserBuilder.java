package com.builder.test;

public class UserBuilder {

	private String name;
	private int age;
	
	public User build() {
		User user = new User();
		user.setAge(this.age);
		user.setName(this.name);
		
		return user;
	}
	public UserBuilder name(String name) {
		this.name = name;
		return this;
	}
	public UserBuilder age(int age) {
		this.age = age;
		return this;
	}
}
