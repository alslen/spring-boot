
package com.example.demo03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo03.domain.CustomUser;
import com.example.demo03.dto.MemberDTO;
import com.example.demo03.mapper.MemberMapper;

@Service  
public class MemberService implements UserDetailsService{ // UserDetailsService을 구현
	@Autowired
	private MemberMapper mMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername");
		MemberDTO member = mMapper.read(username);  // security가 적용된 유저가 아님.
		System.out.println("member : "+member);
		return member==null?null:new CustomUser(member);  // CustomUser을 통해서 security를 적용시킴
	}  

}
