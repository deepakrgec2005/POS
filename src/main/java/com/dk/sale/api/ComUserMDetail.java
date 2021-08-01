package com.dk.sale.api;

 
import java.util.Arrays;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dk.rsale.entity.UserMDetail;

 
public class ComUserMDetail implements UserDetails {
private UserMDetail usermdetails;
	public ComUserMDetail(UserMDetail usermdetails) {
	 
	this.usermdetails = usermdetails;
}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(usermdetails.getRole());
		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return usermdetails.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.usermdetails.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	 
}
