package com.dk.rsale.dao;

import java.util.List;

import com.dk.rsale.entity.Product;

public interface ProductDao {
	 List<Product> getAllProduct();
	 Product getProduct(int id);
	 boolean add(Product product);
	 boolean update(Product product);
	 boolean delete(Product product);
	
}
