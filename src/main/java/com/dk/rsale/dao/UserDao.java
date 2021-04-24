package com.dk.rsale.dao;

import com.dk.rsale.entity.Users;

public interface UserDao {
	Users getByEmail(String email);
	Users get(Long id);
	Users getByUserName(String userName);
	boolean addUser(Users user);
}
