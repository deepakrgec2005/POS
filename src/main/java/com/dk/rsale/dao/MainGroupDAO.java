package com.dk.rsale.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.dk.rsale.entity.MainGroup;

public interface MainGroupDAO extends JpaRepository<MainGroup, Integer> {
	@Transactional
	@Query(value = "UPDATE MainGroup u set Mname =?1 where u.Mid = ?2",
            nativeQuery = true)
void updateMainGroup(String Mname, int id);
 

	 
}
