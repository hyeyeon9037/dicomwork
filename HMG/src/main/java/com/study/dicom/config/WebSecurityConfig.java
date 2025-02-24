package com.study.dicom.config;


//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import jakarta.servlet.DispatcherType;

@Configuration
public class WebSecurityConfig {
	
//	@Autowired
//	AuthenticationFailureHandler authenticationFailureHandler;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
			http.csrf((csrf) -> csrf.disable())
				.cors((cors) -> cors.disable())
				.authorizeHttpRequests(request -> request
						.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
						.requestMatchers("/").permitAll()
						.requestMatchers("/css/**", "/js/**", "/img/**").permitAll()
						.requestMatchers("/admin/**").hasRole("ADMIN")
						.anyRequest().authenticated()
				 );
			
			/*
			http.formLogin((formLogin) -> formLogin.permitAll());
			http.logout((logout) -> logout.permitAll());
			*/
			http.formLogin((formLogin) -> formLogin
					.loginPage("/")	// default : /login 
					.loginProcessingUrl("/login")
					// .failureUrl("/loginError")
					.failureUrl("/?error")
					.defaultSuccessUrl("/index", true)   // 로그인 성공 후 /home으로 리다이렉트
//					.failureHandler(authenticationFailureHandler)
					.usernameParameter("username") // 파라미터 디폴트(j_username)
					.passwordParameter("pwd")      // 파라미터 디폴트(j_password)
					.permitAll());
			
			http.logout((logout) -> logout.permitAll());
			
		
		return http.build();	
	}
	
	// db에 넣지 않고 메모리에 저장
	@Bean
	public UserDetailsService users() {
		UserDetails admin = User.builder()
				.username("admin")
				.password(passwordEncoder().encode("1234"))
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(admin);
	}
	
	// 패스워드 암호화
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
