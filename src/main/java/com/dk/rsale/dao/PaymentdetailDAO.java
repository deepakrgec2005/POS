package com.dk.rsale.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dk.rsale.entity.Paymentdetail;

public interface PaymentdetailDAO extends JpaRepository<Paymentdetail, Integer> {
	 @Query("from Paymentdetail where bid.BillInvId=:bids")  
	List<Paymentdetail> getallbillid(String bids);
	/*
	 * @Query("from Paymentdetail bid.BillInvId=:bid") List<Paymentdetail>
	 * getallbillid(String bid);
	 */

}
