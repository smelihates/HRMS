package Kodlama.io.hrms.business.abstracts;

import java.util.List;

import Kodlama.io.hrms.core.utilities.results.DataResult;
import Kodlama.io.hrms.core.utilities.results.Result;
import Kodlama.io.hrms.entities.concretes.Employer_Confirmation;

public interface Employer_ConfirmationService {
	
	Result register(int id);
	
	DataResult<Employer_Confirmation> getById(int id);
	
	Result confirmateEmployer(int id, int staffId);
	
	DataResult<List<Employer_Confirmation>> findByConfirmatedFalse();
}
