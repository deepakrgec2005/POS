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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table(name="Bill")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bill {
	  
	 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bill_sql")
	@GenericGenerator(name="bill_sql", strategy = "com.dk.rsale.entity.ProductIDGen",parameters = {
			
			@Parameter(name=ProductIDGen.INCREMENT_PARAM, value="1" ),
			@Parameter(name=ProductIDGen.VALUE_PREFIX_PARAMETER, value="INV_"),
			@Parameter(name=ProductIDGen.NUMBER_FORMAT_DEFAULT, value="%05d")
			
	})
	@Id
	private String BillInvId;
	private Date date;
	private String ManualBillid; 
	private int pcs;
	private double qty;
	private double gross;
	private double payamt;
	private double outstanding;
	@ManyToOne(targetEntity = UserMDetail.class,cascade = CascadeType.ALL)
	@JoinColumn(name="user_fk",referencedColumnName = "usermid")
	private UserMDetail user;
	@ManyToOne(targetEntity = Customers.class,cascade = CascadeType.ALL)
	@JoinColumn(name="cs_fk",referencedColumnName = "cid")
	private Customers cs;
}
