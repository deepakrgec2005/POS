package com.dk.rsale.customvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.dk.rsale.Service.UserMDetailService;

public class UniqueUserNameValidator implements ConstraintValidator<Uniqueusername, String>{
	@Autowired
	private UserMDetailService userService;
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		 
		return value !=null && !userService.isUsernameAlreadyInUse(value);
	}

	 

}
