package com.dk.rsale.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dk.rsale.entity.Customers;

public interface CustomersDAO extends JpaRepository<Customers, Integer> {

}
