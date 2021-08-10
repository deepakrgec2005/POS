package com.dk.rsale.security;
  
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 

import com.dk.sale.api.ComUserMDetailService;
@Configuration
@EnableWebSecurity
public class WebConfigDetail extends WebSecurityConfigurerAdapter {
 @Bean
	public UserDetailsService userDetailsService() 
 {
	 return new ComUserMDetailService();
 }
 @Bean
	public BCryptPasswordEncoder  passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
 @Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(userDetailsService());
		return daoAuthenticationProvider;
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authProvider());
		//inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN").and().withUser("deepak").password(passwordEncoder().encode("deepak")).roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/POS/mg").hasRole("ADMIN")
		.antMatchers("/POS/register").hasRole("ADMIN")
		.antMatchers("/POS/login").permitAll()
		.antMatchers("/assets/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/POS/login").permitAll()
		.defaultSuccessUrl("/POS/home", true)
	    .failureUrl("/login?error=true")
		.and()
		.logout().permitAll();
		
		
	}
	
	@Override
	public void configure(WebSecurity web)throws Exception
	{
		web.ignoring().antMatchers("/POS/tr").antMatchers("/POS/pliupdate").antMatchers("/POS/barcodeprintp/**").antMatchers("/POS/prbarcodeprint").antMatchers("/POS/stockOpening").antMatchers("/POS/stockOpeningdet").antMatchers("/POS/logidet").antMatchers("/POS/delete").antMatchers("/POS/userup").antMatchers("/POS/changepass").antMatchers("/POS/stkdetupdate").antMatchers("/POS/openingdelete").antMatchers("/POS/json/barcode").antMatchers("/POS/billdet").antMatchers("/POS/json/stockrg/**").antMatchers("/POS/enddata").antMatchers("/POS/Rsaledt").antMatchers("/POS/rsup").antMatchers("/POS/delrsbill").antMatchers("/POS/paymentdts").antMatchers("/POS/json/paybill/**").antMatchers("/POS/myrsalebillinv/**");
	}

 
	
	
	
	 
	
	
	
}
