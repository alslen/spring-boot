package com.example.demo06.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration  // 환경설정파일이라는 것을 알려줌.
@EnableWebSecurity  // Security라는 것을 알려줌.
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{  // WebSecurityConfigurerAdapter는 추상메서드를 구현한 클래스

	@Bean  // Bean을 등록해줌
	public BCryptPasswordEncoder encodePwd() {  // 암호화 객체를 만들어줌.
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();  // csrf라는 토큰 값을 전달 안하기 위해서 사용
		
		// user로 넘어오는 것들은 권한을 얻음.
		http.authorizeRequests().antMatchers("/user/*").authenticated()
		.anyRequest().permitAll()  // 나머지는 권한 획득x
		.and()
			.formLogin()  // 로그인 페이지
			.loginPage("/login")
			.defaultSuccessUrl("/")  // 로그인 성공하면 /로 이동
		.and()
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true);  // 세션을 끊어줌.
	}
}
