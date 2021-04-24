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
@Table(name="MainGroup")

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString 
public class MainGroup {

@Id
@Column(name="mid")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int Mid;
@Column(name="mname",nullable = false ,length = 10) 
private String Mname;
 
 }
