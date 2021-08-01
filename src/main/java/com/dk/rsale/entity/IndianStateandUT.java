package com.dk.rsale.entity;

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
@Table(name="State")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IndianStateandUT {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
private int stid;
private String Statename; 
}
