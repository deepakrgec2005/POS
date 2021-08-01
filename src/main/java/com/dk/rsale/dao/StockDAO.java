package com.dk.rsale.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dk.rsale.entity.Stock;

public interface StockDAO extends JpaRepository<Stock, String> {

}
