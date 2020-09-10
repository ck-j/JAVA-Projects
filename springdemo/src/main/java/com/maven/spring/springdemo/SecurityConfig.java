package com.maven.spring.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
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
 
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) 
            throws Exception 
    {
        auth.inMemoryAuthentication()
        .withUser("chetan")
        .password("{noop}chetan1")
        .roles("USER")
        .and()
        .withUser("prathima")
        .password("{noop}prathima1")
        .roles("ADMIN");
    }
}