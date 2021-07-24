package com.dk.rsale;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 

@SpringBootApplication
public class RsaleApplication {
	 
	public static void main(String[] args) {
		//OrgDetailService orgDetailService= new OrgDetailService();
		/*
		 * BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); String
		 * rawPassword="admin"; String encodePassword=encoder.encode(rawPassword);
		 * System.out.println(encodePassword);
		 */
			/*
			 * OrgDetail orgDetail = new OrgDetail(); orgDetail.setGSNNo("1A2B3C4D5E");
			 * orgDetail.setIsactive(true); orgDetail.setOrgName("Kaushik and Kaushik");
			 * orgDetailService.createOrg(orgDetail);
			 */
		SpringApplication.run(RsaleApplication.class, args);
	}

}
