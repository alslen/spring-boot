package com.example.demo05.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_order")
public class Order {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderid;
	private String note;
	private String ordername;
	private int price;
	// private String user_id;
	@JoinColumn
	// @ManyToOne : 시작하자마자 조인이 일어남.
	@ManyToOne(fetch = FetchType.LAZY)  // 실행시점까지 delay시켰다가 조인시켜줌.
	private User2 user;
	
	
	
}
