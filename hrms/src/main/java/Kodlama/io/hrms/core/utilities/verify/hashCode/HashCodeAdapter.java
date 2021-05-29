package Kodlama.io.hrms.core.utilities.verify.hashCode;

import org.springframework.stereotype.Service;

import Kodlama.io.hrms.core.utilities.results.DataResult;
import Kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import Kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import Kodlama.io.hrms.hashCode.HashCodeGeneratorService;

@Service
public class HashCodeAdapter implements HashCodeService{

	private HashCodeGeneratorService hashCodeGeneratorService=new HashCodeGeneratorService();
	
	@Override
	public DataResult<String> generateCode() {
		String code=this.hashCodeGeneratorService.generateCode(8);
		
		if(!code.isEmpty()) {
			return new SuccessDataResult<String>
			(code,"Doğrulama kodu üretildi.");
		}
		
		return new ErrorDataResult<String>();

	}

}
