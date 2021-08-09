package com.dk.rsale.entity;

import java.util.Date;

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
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Table(name="Paymentdetail")
public class Paymentdetail {
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
private int pydt;
private String csname;
@ManyToOne(targetEntity = Bill.class,cascade = CascadeType.ALL)
@JoinColumn(name="pydt_fk",referencedColumnName = "BillInvId")
private Bill bid;
/*
 * @ManyToOne(targetEntity = Paymode.class,cascade = CascadeType.ALL)
 * 
 * @JoinColumn(name="pymd_fk",referencedColumnName = "pymid")
 */
private int pymd;
private double amountpaid;
@ManyToOne(targetEntity = UserMDetail.class,cascade = CascadeType.ALL)
@JoinColumn(name="user_fk",referencedColumnName = "usermid")
private UserMDetail user;
private String billno;
private String remarks;
private Date paydate;
}
