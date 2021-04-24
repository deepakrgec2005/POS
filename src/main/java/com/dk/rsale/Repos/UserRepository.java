package com.dk.rsale.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dk.rsale.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

}
