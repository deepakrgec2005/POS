package com.dk.rsale.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dk.rsale.entity.ProductList;



public interface ProductListDAO extends JpaRepository<ProductList, String> {
	@Query(value="select  pr_id as prID ,gstp as GSTPfrom product_list pl",nativeQuery = true)
	List<ProductList> findBySomef();


}
