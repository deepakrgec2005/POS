package com.dk.rsale.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dk.rsale.entity.Supplier;

public interface SupplierDAO extends JpaRepository<Supplier, Integer> {

}
