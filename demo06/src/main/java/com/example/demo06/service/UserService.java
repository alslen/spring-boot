package com.example.demo06.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo06.model.User;
import com.example.demo06.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
public class UserService{
	
	@Autowired
	private BCryptPasswordEncoder encoder;  // 암호화 객체를 사용하기 위해 주입 시켜여함.
	@Autowired
	private UserRepository userRepository;
	
	// 회원가입
	public void register(User user) {  
		// 비번 암호화 시키고 추가
		String rawPassword = user.getPassword();
		String encPassWord = encoder.encode(rawPassword);  // 비번을 암호화 시켜줌
		user.setPassword(encPassWord);  // 암호화된 비번
		user.setRole("ROLE_USER");  // 권한 직접 
		userRepository.save(user);  // user에 들어있는 값을 DB에 insert
	}
	
}
