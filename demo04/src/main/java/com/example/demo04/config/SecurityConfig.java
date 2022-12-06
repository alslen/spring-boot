package com.example.demo04.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
	public BCryptPasswordEncoder encodePwd() {  // 암호화 객체를 만듦
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http.authorizeRequests().antMatchers("/user/*").authenticated()
//		.antMatchers("/admin/**").hasRole("ADMIN")  // admin으로 넘어오는 것은 ROLE_ADMIN권한을 가진다.
//		.antMatchers("/manager/**").hasRole("MANAGER")
			.anyRequest().permitAll()
		.and()
			.formLogin()
			.loginPage("/login")  
			.defaultSuccessUrl("/")  // 로그인을 성공하면 /로 이동
		.and()
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login")	// 로그아웃을 성공하면 /로 이동
			.invalidateHttpSession(true);
	}
}
