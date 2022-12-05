package com.example.demo03.domain;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.example.demo03.dto.MemberDTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CustomUser extends User{   // security가 적용된 user로 바꿔줌.

	private MemberDTO member;
	
	public CustomUser(MemberDTO member) {
		super(member.getUserid(), member.getUserpw(), member.getAuthList().stream()
				.map(auth->new SimpleGrantedAuthority(auth.getAuth()))
				.collect(Collectors.toList()));
		this.member = member; 
	}
}
