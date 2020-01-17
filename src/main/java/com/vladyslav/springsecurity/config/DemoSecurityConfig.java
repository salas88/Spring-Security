package com.vladyslav.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// add our users for in memory authentication
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("Vlad").password("test123").roles("EMPLOYER", "ADMIN"))
			.withUser(users.username("Gaga").password("test123").roles("EMPLOYER"))
			.withUser(users.username("Karim").password("test123").roles("EMPLOYER", "MANAGER"));
		
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
				.antMatchers("/").hasRole("EMPLOYER")
				.antMatchers("/leaders/**").hasRole("MANAGER")
				.antMatchers("/admins/**").hasRole("ADMIN")
			.and()
			.formLogin()
				.loginPage("/showPageforLogin")
				.loginProcessingUrl("/autinicatedPage")
				.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
	}
	
	

}
