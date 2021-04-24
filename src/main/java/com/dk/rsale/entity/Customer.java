package com.dk.rsale.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Table(name="customer")
public class Customer {
	@Id
	private int cid;
    private String cname;
    private String phone;
    
}
