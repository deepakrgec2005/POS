package com.dk.rsale.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dk.rsale.entity.NewBarcodeCreator;

public interface NewBarcodeGen extends JpaRepository<NewBarcodeCreator, Integer> {

}
