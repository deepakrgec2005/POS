package com.dk.rsale.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Table(name="users")
@ToString
@AllArgsConstructor
@NoArgsConstructor
 
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userId")
	private Long userId;
	@Column(nullable=false, length=64, name="userName")
	private String userName;
	@Column(nullable=false, unique=true, length=45)
	private String email;
	@Column(nullable=false, length=64)
	private String password;

}
