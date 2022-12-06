package com.example.demo05.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User { // 일대일 관계의 양방향

	@Id
	private String email;
	private String name;
	private Date createdDate;
	@OneToOne(mappedBy = "owner")  // 바라만 보게 하기 위해서 mappedBy키워드를 사용
	private MemberShipCard card;
}
