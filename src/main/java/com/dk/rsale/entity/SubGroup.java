package com.dk.rsale.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
@Table
@Entity(name="SubGroup")
@Data
public class SubGroup {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int sid;
@Column(name="SubGroup_Name",nullable = false ,length = 10)
private String sname;
@ManyToOne(targetEntity = MainGroup.class,cascade = CascadeType.ALL)
@JoinColumn(name="mg_fk",referencedColumnName = "mid")
 
private MainGroup mg;
}
