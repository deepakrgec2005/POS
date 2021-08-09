package com.dk.rsale.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dk.rsale.entity.BillDetail;

public interface BillDetailDAO extends JpaRepository<BillDetail, Integer> {
	
	@Query("SELECT SUM(net+discount) FROM BillDetail  where bill.BillInvId=:s")
	Double getgrossstotal(String s);
	@Query("SELECT SUM(pcs) FROM BillDetail  where bill.BillInvId=:s")
	int getpcstotal(String s);
	@Query("SELECT SUM(qty) FROM BillDetail  where bill.BillInvId=:s")
	Double getqtytotal(String s);
	@Query("from BillDetail where bill.BillInvId=:s")
	BillDetail findbyBillID(String s);
	@Query("SELECT SUM(net*(1+(gst/100))) FROM BillDetail  where bill.BillInvId=:s")
	Double sumofoutstanding(String s);
	@Query("from BillDetail where bill.BillInvId=:billdid and barcode=:barcode")
	BillDetail updetsaw(String barcode, String billdid);
	@Query("from BillDetail where bill.BillInvId=:billid")
	List<BillDetail> getbillitem(String billid);
	@Modifying
	@Query("UPDATE BillDetail set pcs=:pcs, qty=:qty,net=:net where billdid=:billdid1")
	public void upbildt(int billdid1, int pcs, double qty, double net);
	 
}
