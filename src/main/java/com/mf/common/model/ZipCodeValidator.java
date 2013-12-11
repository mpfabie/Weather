package com.mf.common.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ZipCodeValidator implements ConstraintValidator<ZipCode, String>{

	 @Override
	    public void initialize(ZipCode zipcode) { }
	 
	    @Override
	    public boolean isValid(String phoneField, ConstraintValidatorContext cxt) {
	        if(phoneField == null) {
	            return false;
	        }
	        try{
	        	Integer.parseInt(phoneField);
	        }catch(NumberFormatException e){
	        	return false;
	        }
	        return phoneField.matches("\\d{5}");
	    }
}
