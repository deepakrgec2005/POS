package com.dk.rsale.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="Stock")

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString 
public class Stock {
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_sql")
	@GenericGenerator(name="stock_sql", strategy = "com.dk.rsale.entity.ProductIDGen",parameters = {
			
			@Parameter(name=ProductIDGen.INCREMENT_PARAM, value="1" ),
			@Parameter(name=ProductIDGen.VALUE_PREFIX_PARAMETER, value="ST_"),
			@Parameter(name=ProductIDGen.NUMBER_FORMAT_DEFAULT, value="%05d")
	})
	@Id
	private String stockid;
	private String stocktype;
	private Date Stockon;
	private Double amount;
	private int nor;
}
