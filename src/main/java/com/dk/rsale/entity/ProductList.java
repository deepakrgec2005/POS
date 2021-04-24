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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductList {
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "demo_sql")
	@GenericGenerator(name="demo_sql", strategy = "com.dk.rsale.entity.StringPrefixedSequenceGenerator",parameters = {
			
			@Parameter(name=StringPrefixedSequenceGenerator.INCREMENT_PARAM, value="1" ),
			@Parameter(name=StringPrefixedSequenceGenerator.VALUE_PREFIX_PARAMETER, value="KAUSHIK_"),
			@Parameter(name=StringPrefixedSequenceGenerator.NUMBER_FORMAT_DEFAULT, value="%05d")
	})
@Id
private String PrId;
 
private String PName;
private String PSName;
private String PType;
 
private int HSNCODE;
private int GSTP;
private int GSTonSale;
private int GSTPM;
@Column(insertable = true)
@JsonIgnore
private Boolean active;
@ManyToOne(targetEntity = SubGroup.class,cascade = CascadeType.ALL)
@JoinColumn(name="sg_fk",referencedColumnName = "sid")
private SubGroup sg;
private int mid;
}
