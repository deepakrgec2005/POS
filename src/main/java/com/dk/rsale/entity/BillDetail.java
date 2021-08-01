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
@Table(name="BillDetail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BillDetail {
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
private int billdid;
private String barcode;
//private String prname;
@ManyToOne(targetEntity = ProductList.class,cascade = CascadeType.ALL)
@JoinColumn(name="pl_fk",referencedColumnName = "PrId")
private ProductList prname;
private double bprice; 
 
private int pcs;
private double qty;
private double discount;
private double net;
private double gst;
private double payable;
@ManyToOne(targetEntity = Bill.class,cascade = CascadeType.ALL)
@JoinColumn(name="bl_fk",referencedColumnName = "BillInvId")
private Bill bill;

}
