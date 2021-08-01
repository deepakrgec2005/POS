package com.dk.rsale.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dk.rsale.entity.InwardRegister;

public interface InwardRegisterDAO extends JpaRepository<InwardRegister, String>{
	@Query("from InwardRegister where intype=:atype") 
	List<InwardRegister> findbySANam(@Param("atype") String intype);
	 

	 

	 

}
