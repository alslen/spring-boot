package com.builder.test;

public class User {

	private String name;
	private int age;
	
	public static UserBuilder builder() {
		return new UserBuilder();  // 생성자를 만듦어서 반환해줌.
	}
	
	//getter, setter
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
