package Kodlama.io.hrms.business.abstracts;

import Kodlama.io.hrms.core.utilities.results.DataResult;
import Kodlama.io.hrms.core.utilities.results.Result;
import Kodlama.io.hrms.entities.concretes.Email_Verification;

public interface Email_VerificationService {

	Result register(int id);
	
	DataResult<Email_Verification> getById(int id);
	
	Result setValidate(int id, String code);
	
	
	
	
	
}
