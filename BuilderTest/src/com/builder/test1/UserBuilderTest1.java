package com.builder.test1;

import org.junit.Test;

import com.builder.test.User;

public class UserBuilderTest1 {

	@Test
	public void builerTest1() {
		User user = User.builder() // builder()를 부름
				.name("홍길동") // getter와 setter를 불러서 처리하는 것처럼 보임
				.age(20)
				.build();

			System.out.println(user);
			
			User user1 = User.builder() // builder()를 부름
					.age(200) // getter와 setter를 불러서 처리하는 것처럼 보임
					.name("홍길동22")
					.build();

				System.out.println(user1);
	}
	
}
