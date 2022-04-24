package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.services.accounts_service;

@EnableWebSecurity
public class bankappsecurity extends  WebSecurityConfigurerAdapter{
	@Autowired 
	  private accounts_service accountserve;

		 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	        .authorizeRequests()
	        .antMatchers("/").permitAll()

	            .anyRequest().authenticated()
	            .and()
	            .formLogin().permitAll()
	            .and()
	            .logout().permitAll();
		 }


	    
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(daoAuthenticationProvider());
	    }

	    @Bean
	    public PasswordEncoder encoder(){
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    @Override
	    protected AuthenticationManager authenticationManager() throws Exception {
	        return super.authenticationManager();
	    }
	    

	    public DaoAuthenticationProvider daoAuthenticationProvider(){
	        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
	        provider.setUserDetailsService(accountserve);
	        provider.setPasswordEncoder(encoder());
	        return provider;
	    }

	    
	    
	
	

}
