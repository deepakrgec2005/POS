package com.dk.rsale.entity;

 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="orgdetail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrgDetail {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	/* purchase Id*/
	private String orgid;
	private String OrgName;
	private Boolean isactive;
	private String GSNNo;
	
}
