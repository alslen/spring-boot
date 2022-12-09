package com.example.demo06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo06.config.auth.PrincipalUser;
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
		user.setRole("ROLE_ADMIN");  // 권한 직접 
		userRepository.save(user);  // user에 들어있는 값을 DB에 insert
	}
	
	// 회원정보 
	public User findById(String username) {
		return userRepository.findByUsername(username);
	}
	
	// 삭제
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
	// 수정
	public void update(User user) {
		User u = userRepository.findById(user.getId()).get();
		u.setEmail(user.getEmail());
	}
	
	// 회원 목록
	public List<User> findAll(){
		
		return userRepository.findAll();
	}
	
	// 회원 수
	public Long getCount() {
		return userRepository.count();
	}
	
}
