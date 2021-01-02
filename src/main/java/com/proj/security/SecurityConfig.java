package com.proj.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select cin as principal,password as credentials, active from `medcin` where cin=?")
		.authoritiesByUsernameQuery("select cin as principal,role as role from `medcin` where cin=?")
		.passwordEncoder(getPasswordEncoder() )
		.rolePrefix("ROLE_")
		;
		
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select cin as principal,password as credentials, active from `admin` where cin=?")
		.authoritiesByUsernameQuery("select cin as principal,role as role from `admin` where cin=?")
		.passwordEncoder(getPasswordEncoder() )
		.rolePrefix("ROLE_")
		;
		
		
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.formLogin().loginPage("/login");
		http.authorizeRequests().antMatchers("/medcin/*").hasRole("MEDCIN");
		http.authorizeRequests().antMatchers("/admin/*").hasRole("ADMIN");
		//http.authorizeRequests().antMatchers("/").permitAll();
		
		http.exceptionHandling().accessDeniedPage("/403");
	}

	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
	    return NoOpPasswordEncoder.getInstance();
	}

}
