package com.dk.rsale.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dk.rsale.entity.UserMDetail;

public interface UserMasterDAO extends JpaRepository<UserMDetail, String> {
	@Query("SELECT u from UserMDetail u where u.username=:username")
	public UserMDetail getUserMDetailByUserName(@Param("username")String username);
	@Modifying
	@Query("UPDATE UserMDetail u set u.enabled=:bar where u.usermid=:id")
	public int updsta(@Param("id")String id, @Param("bar")Boolean bar);
	@Modifying
	@Query("UPDATE UserMDetail u set u.password=:changepass where u.usermid=:userid")
	public void uppass(@Param("userid") String userid, @Param("changepass") String changepass);

	 

}
