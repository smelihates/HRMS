package Kodlama.io.hrms.core.utilities.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.hrms.business.abstracts.UserService;
import Kodlama.io.hrms.core.utilities.results.ErrorResult;
import Kodlama.io.hrms.core.utilities.results.Result;
import Kodlama.io.hrms.core.utilities.results.SuccessResult;
import Kodlama.io.hrms.core.utilities.verify.mernis.MernisVerifyService;


@Service
public class ValidationManager implements ValidationService{
	
	private UserService userService;
	private MernisVerifyService mernisVerifyService;
	
	
	@Autowired
	public ValidationManager(UserService userService,
			MernisVerifyService mernisVerifyService) {
		super();
		this.userService = userService;
		this.mernisVerifyService=mernisVerifyService;
	}

	@Override
	public Result validatePassword(String password, String password2) {
		
		if (password.isEmpty() ||password2.isEmpty()) {
			return new ErrorResult("password alanı boş bırakılamaz!");
		}
		if(password.equals(password2)) {
			
			return new SuccessResult();
		}

		return new ErrorResult("password ve password again alanları uyumsuz!");

	}

	@Override
	public Result validateEmail(String email) {
		if(email.isEmpty()) {
			return new ErrorResult("Email adresi boş bırakılamaz!");
		} else if(!isEmailValid(email).isSuccess() ) {
			return new ErrorResult(isEmailValid(email).getMessage());
		}
		else if(this.userService.getByEmail(email).getData()==null) {
			
			return new SuccessResult();
		}
		return new ErrorResult("Bu email adresi sistemde kayıtlı!");
		
	}

	@Override
	public Result validateIdentifyNumber(String firstName, String surName, String identificationNo, String birthDate) {
		Boolean result=this.mernisVerifyService.TcNoVerify( firstName,  surName,  identificationNo,  birthDate).isSuccess();
		if (result) {
			return new SuccessResult();
		}
		return new ErrorResult("TC numarası doğrulanamamıştır!");
	}

	@Override
	public Result validateBlankField(String value) {
		if(value.isEmpty()) {
			return new ErrorResult(" alan değeri boş bırakılamaz!");
		}
		return new SuccessResult();
	}

	private Result isEmailValid(String email) {
		String expression="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		CharSequence inputStr=email;
		
		Pattern pattern=Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher=pattern.matcher(inputStr);
		
		if (!matcher.matches()) {
			
			return new ErrorResult("Bu email adresi belirtilen formata uygun değil!");
		}
		
		return new SuccessResult();
	}
}
