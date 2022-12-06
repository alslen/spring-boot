package com.builder.test;

import org.junit.Test;

public class UserBuilderTest {
	@Test
	public void userbuilderTest() {
		User user = User.builder() // builder()를 부름
					.name("홍길동") // getter와 setter를 불러서 처리하는 것처럼 보임
					.age(20)
					.build();
		
		System.out.println(user);
		
		User user1 = User.builder() // builder()를 부름
				.age(33)
				.name("횽길순")
				.build();
		System.out.println(user1);
	}

}
