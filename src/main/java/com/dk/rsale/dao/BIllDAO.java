package com.dk.rsale.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
 

import com.dk.rsale.entity.Bill;

public interface BIllDAO extends JpaRepository<Bill, String> {

	

	
	@Modifying
	@Query("UPDATE Bill u set u.gross=:sumofgross,u.pcs=:sumofpcs, u.qty=:sumofqty, u.outstanding=:sumofoutstanding where u.BillInvId=:s")
	 void updatepcsqtygross(Double sumofgross, int sumofpcs, Double sumofqty, Double sumofoutstanding, String s);

	   
}
