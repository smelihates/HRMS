package Kodlama.io.hrms.core.utilities.validation;

import Kodlama.io.hrms.core.utilities.results.Result;

public interface ValidationService {

	Result validatePassword(String password, String password2);
	
	Result validateEmail(String email);
	
	Result validateIdentifyNumber(String firstName, String surName, String identificationNo, String birthDate);
	
	Result validateBlankField(String value);
	
	Result validateEmailWebAddressDomain(String email, String webAddress);
	
}
