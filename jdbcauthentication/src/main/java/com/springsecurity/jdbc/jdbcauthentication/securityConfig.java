package com.springsecurity.jdbc.jdbcauthentication;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;


@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	javax.sql.DataSource datasourM;
	
	@Override
    public void configure(AuthenticationManagerBuilder auth) 
            throws Exception 
    {
        auth.jdbcAuthentication()
        .dataSource(datasourM)
        .withDefaultSchema()
        .withUser(User.withUsername("chetan").password("{noop}chetan1").roles("USER"))
        .withUser(User.withUsername("prathima").password("{noop}prathima1").roles("ADMIN"));
        		
        		
       
    }

	
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception 
	    {
	        http
	         //.csrf().disable()
	         .authorizeRequests()
	         .antMatchers("/Admin").hasRole("ADMIN")
	         .antMatchers("/User").hasRole("USER")
	         //.antMatchers("/User").permitAll()
	         .antMatchers("/").permitAll()
	         .and().formLogin();
	         //.httpBasic();
	         http.headers().frameOptions().disable();
	        
	    }
	 
	 
}
