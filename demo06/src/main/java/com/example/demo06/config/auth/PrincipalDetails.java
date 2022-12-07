package com.example.demo06.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo06.model.User;
import com.example.demo06.repository.UserRepository;

// 시큐리티 로그인
@Service
public class PrincipalDetails implements UserDetailsService{

	// 로그인을 하면 loadUserByUsername이 제일 먼저 실행됨
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername");
		
		User user = userRepository.findByUsername(username);  // username으로 조회
		if(user == null) return null;  // 회원이 아니면 null로 리턴
		// 회원이라면 시큐리티가 적용된 User로 반환
		PrincipalUser puser = new PrincipalUser(user);
		System.out.println("puser : "+puser);
		return puser;
	}  

}
