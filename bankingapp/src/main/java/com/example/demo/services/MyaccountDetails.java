package com.example.demo.services;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import DTO.accountDTO;

public class MyaccountDetails implements UserDetails {
	 private accountDTO account;

	    


	    public MyaccountDetails(accountDTO account) {
	        this.account = account;
	    }
	    public MyaccountDetails (){}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//account users all have the same role. No need for this method implementation....
		return null;
	}

	@Override
	public String getPassword() {
		return account.getAccount_password();
	}

	@Override
	public String getUsername() {
				return account.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
				return true;
	}

}
