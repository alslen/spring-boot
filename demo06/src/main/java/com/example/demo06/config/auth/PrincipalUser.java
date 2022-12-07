package com.example.demo06.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo06.model.User;

import lombok.Getter;

// 시큐리티가 적용한 User로 변경해줌.
@Getter  // user가 반환되어야하니까 
public class PrincipalUser implements UserDetails{ // User로 상속 받아도 됨
	
	private User user;
	
	public PrincipalUser(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		Collection<GrantedAuthority> collect = new ArrayList<>();  // 권한은 여러 값을 가지기 때문에
		collect.add(()->{
			return user.getRole();
		});
		return collect;
	}

	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
	
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
