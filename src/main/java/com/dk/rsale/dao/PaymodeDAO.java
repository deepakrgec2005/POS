package com.dk.rsale.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dk.rsale.entity.Paymode;

public interface PaymodeDAO extends JpaRepository<Paymode, Integer> {

}
