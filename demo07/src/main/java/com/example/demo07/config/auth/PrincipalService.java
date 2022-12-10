package com.example.demo07.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo07.model.Member;
import com.example.demo07.repository.memberRepository;

@Service
public class PrincipalService implements UserDetailsService{
	@Autowired
	private memberRepository mRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = mRepository.findByUsername(username);
		if(member == null) return null;
		
		PrincipalUser puser = new PrincipalUser(member);
		return puser;
	}

}
