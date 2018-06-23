package com.java.emt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.inMemoryAuthentication()
		.withUser("DODO").password("{noop}password123").roles("admin")
		.and()
		.withUser("user").password("{noop}password123").roles("manager");
}

    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().csrf().disable().
		authorizeRequests()
		.antMatchers("/deleteEmp/**").hasAnyRole("admin","manager").and().formLogin();
    }

}
