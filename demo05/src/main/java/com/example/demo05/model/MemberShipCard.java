package com.example.demo05.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class MemberShipCard {  // 일대일 관계의 양방향

	@Id
	private String cardNumber;
	@JoinColumn(name="user_email") // 외래키 지정
	@OneToOne  // 일대일 관계
	private User owner;
	private Date expriyDate;
	private boolean enabled;
}
