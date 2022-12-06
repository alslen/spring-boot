package com.example.demo04.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo04.Mapper.MemberMapper;
import com.example.demo04.domain.CustomUser;
import com.example.demo04.dto.MemberDTO;

@Service
public class MemberService implements UserDetailsService{

	@Autowired
	private MemberMapper mMapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername");
		MemberDTO member = mMapper.read(username);
		System.out.println("member : "+member);
		return member==null?null:new CustomUser(member);
	}

}
