package com.dk.rsale.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dk.rsale.entity.Purchase;

public interface PurchaseDAO extends JpaRepository<Purchase, String> {

}
