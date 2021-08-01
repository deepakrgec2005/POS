package com.dk.rsale.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table(name="stockdetail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StockDetail {
	@Id
	private String barcode;
	@ManyToOne(targetEntity = Stock.class,cascade = CascadeType.ALL)
	@JoinColumn(name="stk_fk",referencedColumnName = "stockid")
	private Stock stkid;
	private int pcs;
	private double qty;
	/* Base Value*/
	private double bvalue;
	private double mrp;
	@ManyToOne(targetEntity = Supplier.class,cascade = CascadeType.ALL)
	@JoinColumn(name="sp_fk",referencedColumnName = "sid")
	private Supplier supid;
	@ManyToOne(targetEntity = ProductList.class,cascade = CascadeType.ALL)
	@JoinColumn(name="pl_fk",referencedColumnName = "PrId")
	private ProductList pl;
	private String sttype;
}
