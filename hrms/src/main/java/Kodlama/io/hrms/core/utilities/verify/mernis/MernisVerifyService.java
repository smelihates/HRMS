package Kodlama.io.hrms.core.utilities.verify.mernis;



import Kodlama.io.hrms.core.utilities.results.Result;

public interface MernisVerifyService {
	Result TcNoVerify(String firstName, String surName, String identificationNo,String birthDate);
}
