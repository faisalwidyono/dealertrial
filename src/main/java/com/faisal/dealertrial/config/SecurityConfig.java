package com.faisal.dealertrial.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.faisal.dealertrial.service.SalesServices;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private SalesServices salesService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and()
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/admin/**").hasAuthority("admin")
		.antMatchers("/bigbike/**").hasAnyAuthority("admin", "bigbike")
		.antMatchers("/bike/**").hasAnyAuthority("admin", "bigbike", "bike")
		.and().formLogin().permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(salesService).passwordEncoder(encoder());
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
