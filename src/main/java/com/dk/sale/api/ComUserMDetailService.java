package com.dk.sale.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dk.rsale.dao.UserMasterDAO;
import com.dk.rsale.entity.UserMDetail;
 
 
public class ComUserMDetailService implements UserDetailsService {
@Autowired
	private UserMasterDAO usermds;

 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 UserMDetail getuser = usermds.getUserMDetailByUserName(username);
		 
		 if(getuser==null || !getuser.isEnabled()) {
			 throw new UsernameNotFoundException("Could not find user");
		 }
		 
		 
		 
		  
		return new ComUserMDetail(getuser);
	}

}
