package com.dk.rsale.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table(name="Customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customers {
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
private int cid;
private String cname;
private String caddress;
private String cnumber;
private String gstno;
@ManyToOne(targetEntity = IndianStateandUT.class,cascade = CascadeType.ALL)
@JoinColumn(name="state_fk",referencedColumnName = "stid")
private IndianStateandUT isut;
}
