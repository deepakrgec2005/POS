package com.dk.rsale.entity;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="stockdetailbarc")
public class stockdetailbarc {
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "barcode_sql")
	@GenericGenerator(name="barcode_sql", strategy = "com.dk.rsale.entity.BarcodeIdGen",parameters = {
			
			@Parameter(name=BarcodeIdGen.INCREMENT_PARAM, value="1" )
			
	})
	@Id
	private String barc;
	private String stockiddetail;
}
