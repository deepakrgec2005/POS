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
@Table(name="purchase")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Purchase {
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchase_sql")
	@GenericGenerator(name="purchase_sql", strategy = "com.dk.rsale.entity.ProductIDGen",parameters = {
			
			@Parameter(name=ProductIDGen.INCREMENT_PARAM, value="1" ),
			@Parameter(name=ProductIDGen.VALUE_PREFIX_PARAMETER, value="PR_"),
			@Parameter(name=ProductIDGen.NUMBER_FORMAT_DEFAULT, value="%05d")
	})
	@Id
	/* purchase Id*/
	private String pid;
	/* purchase Date*/
	private Date pdate;
	/* purchase Supplier Inv*/
	private String splinv;
	/* supp Inv Date*/
	private Date spldt;
	/* product id*/
	@ManyToOne(targetEntity = ProductList.class,cascade = CascadeType.ALL)
	@JoinColumn(name="pl_fk",referencedColumnName = "PrId")
	private ProductList pl;
	/* barcode*/
	private String barcode;
	private int pcs;
	private double qty;
	/* Base Value*/
	private double bvalue;
	private double mrp;
	@ManyToOne(targetEntity = Supplier.class,cascade = CascadeType.ALL)
	@JoinColumn(name="splid",referencedColumnName = "sid")
	private Supplier splid;
	private Date exdate;
	/* supplier discount*/
	private double spldis;
	private double spltax;
}
