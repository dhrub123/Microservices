package com.dhruba.microservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig extends GlobalAuthenticationConfigurerAdapter {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
			.withUser("agoldberg").password(passwordEncoder().encode("pass1")).roles("USER").and()
			.withUser("bgoldberg").password(passwordEncoder().encode("pass2")).roles("USER", "OPERATOR");
	}
}
