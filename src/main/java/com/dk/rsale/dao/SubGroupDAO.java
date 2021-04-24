package com.dk.rsale.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dk.rsale.entity.SubGroup;

public interface SubGroupDAO extends JpaRepository<SubGroup, Integer> {

	
}
