package com.dk.rsale.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dk.rsale.entity.StockRegister;

public interface StockRegisterDAO extends JpaRepository<StockRegister, String> {
	 
	 

}
