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
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dk.rsale.customvalidation.Uniqueusername;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="UserMaster")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserMDetail {
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sql")
	@GenericGenerator(name="user_sql", strategy = "com.dk.rsale.entity.ProductIDGen",parameters = {
			
			@Parameter(name=ProductIDGen.INCREMENT_PARAM, value="1" ),
			@Parameter(name=ProductIDGen.VALUE_PREFIX_PARAMETER, value="User_"),
			@Parameter(name=ProductIDGen.NUMBER_FORMAT_DEFAULT, value="%05d")
	})
	@Id
	private String usermid;
	@NotBlank(message="Enter username")
	@Column(nullable=false,unique=true,length=64)
	@Uniqueusername
	private String username;
	@Column(nullable=false, length=64)
	@NotBlank(message="Enter password")
	private String password;
	private String role;
	private boolean enabled;
	@ManyToOne(targetEntity = OrgDetail.class,cascade = CascadeType.ALL)
	@JoinColumn(name="orgid",referencedColumnName = "orgid")
	private OrgDetail orgdetail;
	@NotBlank(message="Enter your email")
	@Column(nullable=false, length=45)
	private String email;
	@NotBlank(message="Enter your First Name")
	@Column(name="first_name")
	private String firstName;
	@NotBlank(message="Enter your Last Name")
	@Column(name="last_name")
	private String LastName;
	@Column(name="contact_number")
	private String contactNumber;
}
