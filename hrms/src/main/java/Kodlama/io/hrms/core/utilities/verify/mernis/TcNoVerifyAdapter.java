package Kodlama.io.hrms.core.utilities.verify.mernis;



import org.springframework.stereotype.Service;

import Kodlama.io.hrms.core.utilities.results.ErrorResult;
import Kodlama.io.hrms.core.utilities.results.Result;
import Kodlama.io.hrms.core.utilities.results.SuccessResult;
import Kodlama.io.hrms.mernisVerify.MernisService;

@Service
public class TcNoVerifyAdapter implements MernisVerifyService {

	private MernisService mernisService= new MernisService();

	@Override
	public Result TcNoVerify(String firstName, String surName, String identificationNo, String birthDate) {
		boolean verified=this.mernisService.TcNoVerify(firstName, surName, identificationNo, birthDate);
		
		if (!verified) {
			return new ErrorResult(identificationNo+" no ilgili kişiye ait değildir!");
		}
		
		return new SuccessResult (identificationNo+" no doğrulanmıştır."); 
	}
	


}
