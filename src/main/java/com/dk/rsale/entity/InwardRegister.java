package com.dk.rsale.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table(name="inward")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InwardRegister {
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inward_sql")
	@GenericGenerator(name="inward_sql", strategy = "com.dk.rsale.entity.ProductIDGen",parameters = {
			
			@Parameter(name=ProductIDGen.INCREMENT_PARAM, value="1" ),
			@Parameter(name=ProductIDGen.VALUE_PREFIX_PARAMETER, value="PR_"),
			@Parameter(name=ProductIDGen.NUMBER_FORMAT_DEFAULT, value="%05d")
	})
	@Id
	private String pid;
	/* purchase Date*/
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	 
	private Date pdate;
	/* purchase Supplier Inv*/
	@Column(nullable = false)
	private String splinv;
	/* supp Inv Date*/
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date spldt;
	/* product id*/
	
	@ManyToOne(targetEntity = Supplier.class,cascade = CascadeType.ALL)
	@JoinColumn(name="splid",referencedColumnName = "sid")
	private Supplier splid;
	private String intype;
	private Boolean transf;
}
