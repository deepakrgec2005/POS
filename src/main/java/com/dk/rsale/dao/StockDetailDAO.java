package com.dk.rsale.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dk.rsale.entity.StockDetail;

public interface StockDetailDAO extends JpaRepository<StockDetail, String> {
	@Query("from StockDetail where stkid.stockid in (:prida) ORDER BY barcode")
	List<StockDetail> findbyStkId(List<String> prida);

	@Query("SELECT SUM(mrp*pcs*qty) FROM StockDetail  where stkid.stockid=:pid")
	Double getprsum(String pid);
	@Query("SELECT COUNT(*) FROM StockDetail  where stkid.stockid=:pid") 
	int getprrowcount(String pid);
	@Query("Select barcode,pcs,qty,bvalue,mrp FROM StockDetail")
	List<Object[]> finddetail();
	@Query("FROM StockDetail where barcode like '%'||:sa||'%'")
	List<StockDetail> findlike(String sa);

}
