package com.dk.rsale.Service;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dk.rsale.dao.UserMasterDAO;
import com.dk.rsale.entity.UserMDetail;
@Service
@Transactional
public class UserMDetailService {
	@Autowired
	private SessionFactory	ses;
	@Autowired
	UserMasterDAO umdao;

	public UserMDetail addMasterUser(UserMDetail um) {
		return umdao.save(um);

	}
	public UserMDetail finduser(String id)
	{
		return umdao.findById(id).orElse(null);
		
	}
	public List<UserMDetail> getalluser() {
		return umdao.findAll();
		
	}
	public UserMDetail getuser(String s)
	{
		UserMDetail user;
		try {
			user =umdao.getUserMDetailByUserName(s);
		} catch (NoResultException e) {
		user = null;
	}
	
	return user;
	 
	}
 
	 public boolean isUsernameAlreadyInUse(String s)
	 {
		 boolean userInDb = true;
			if (getuser(s) == null) 
				userInDb = false;
			return userInDb;
		 
		  
	 }
	public String updateaactdect(String id, Boolean bar) {
		System.out.println("value of bar inside userm"+bar);
		 int updsta = umdao.updsta(id,bar);
		 if(updsta==1)
		 {
			 return "success";
		 }
		 else {
			 return "fail";
		 }
		 
	}
	public void updatepass(String userid, String changepass) {
		 umdao.uppass(userid,changepass);
		
	}
}
