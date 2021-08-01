package com.dk.rsale.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



import com.dk.rsale.entity.Purchasedetail;

public interface PurchasedetailDAO extends JpaRepository<Purchasedetail, String> {

	@Query("from Purchasedetail where inid.pid in (:atype) ORDER BY barcode") 
	List<Purchasedetail> findbyPrID(@Param("atype") List<String> intype);
	
	@Query("SELECT SUM(mrp*pcs*qty) FROM Purchasedetail  where inid.pid=:pid")
	Double getprsum(String pid);
	@Query("SELECT COUNT(*) FROM Purchasedetail  where inid.pid=:pid") 
	int getprrowcount(String pid);

}
 