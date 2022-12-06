package com.builder.test1;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder  // 생성자를 매개변수 순서에 상관없이 setter, getter를 사용하게 할 수 있는 어노테이션
public class User {

	private String name;
	private int age;
}
