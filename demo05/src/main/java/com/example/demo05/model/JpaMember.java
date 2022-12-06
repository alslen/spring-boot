package com.example.demo05.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity  // 객체가 만들어짐과 동시에 테이블을 만들어줌. == 객체와 테이블을 매핑
public class JpaMember {  // 중간 대문자를 만나면 _가 생성됨.

	//@Id는 기본키를 지정(기본키로 지정할 변수명 위에 적음)
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String password;
	private String email;
	private String memo;
	// 필드와 컬럼 매핑 : @Column
	@Column(name="address")  // column명을 address로 변경
	private String addr;
}
