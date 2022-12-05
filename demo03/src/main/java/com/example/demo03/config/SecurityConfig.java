package com.example.demo03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration  // 환결설정 파일이라는 것을 알려주는 어노테이션
public class SecurityConfig extends WebSecurityConfigurerAdapter{ 

	@Bean  // Bean객체를 만들어줌.
	public BCryptPasswordEncoder encodePwd() {  // 암화된 객체를 만들어줌.
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();  //csrf를 사용x
		
		// user로 넘어오는 것은 권한을 획득해야하고(/user/*인 요청은 인증되어야 함을 명시) 나머지는 다 허용
		http.authorizeRequests().antMatchers("/user/*").authenticated()
			.anyRequest().permitAll()
		.and()
			.formLogin()
			.loginPage("/login") //로그인 페이지를 지정  
			.loginProcessingUrl("/loginPro")
			.defaultSuccessUrl("/")  // 성공을 하면 /로 넘어가라
		.and()
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/")  // 로그아웃은 성공적으로 되면 /로 넘어가라
			.invalidateHttpSession(true);  // 세션을 끊어줌.
		
	}
}
