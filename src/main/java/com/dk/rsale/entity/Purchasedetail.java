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
@Table(name="purdetail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Purchasedetail {
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "barcode_sql")
	@GenericGenerator(name="barcode_sql", strategy = "com.dk.rsale.entity.BarcodeIdGen",parameters = {
			
			@Parameter(name=BarcodeIdGen.INCREMENT_PARAM, value="1" )
			
	})
	@Id
	private String barcode;
	/* purchase Date*/
	 
	/* product id*/
	@ManyToOne(targetEntity = ProductList.class,cascade = CascadeType.ALL)
	@JoinColumn(name="pl_fk",referencedColumnName = "PrId")
	private ProductList pl;
	/* barcode*/

	
	  @ManyToOne(targetEntity = InwardRegister.class,cascade = CascadeType.ALL) 
	  @JoinColumn(name="in_fk",referencedColumnName = "pid")
	private InwardRegister inid;
	private int pcs;
	private double qty;
	/* Base Value*/
	private double bvalue;
	private double mrp;
	 
	private Date exdate;
	/* supplier discount*/
	private double spldis;
	private double spltax;
	 
}
