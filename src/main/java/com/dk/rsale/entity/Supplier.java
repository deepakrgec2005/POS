package com.dk.rsale.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="supplier")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	@NotBlank(message="Please enter Supplier Name!")
 
	private String sname;
	@NotBlank(message="Please enter GSTNO!")
	private String gstno;
	@NotBlank(message="Please enter address")
	private String add1;
	private String add2;
	@NotBlank(message="Please enter City!")
	private String city;
	@NotBlank(message="Please enter District!")
	private String distrcit;
	@NotBlank(message="Please enter State!")
	private String State;
	@Size(min=6, max=6, message="6 digit Pincode ")
	private String pincode;
	private String phoneno;
	private String mobile;
	@NotBlank(message="Please enter email!")
	@Email
	private String email;
	 
	

}
