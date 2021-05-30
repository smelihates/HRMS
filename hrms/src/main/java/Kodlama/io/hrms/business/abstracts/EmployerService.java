package Kodlama.io.hrms.business.abstracts;

import java.util.List;

import Kodlama.io.hrms.core.utilities.results.DataResult;
import Kodlama.io.hrms.core.utilities.results.Result;
import Kodlama.io.hrms.entities.concretes.Employer;

public interface EmployerService {
	
	Result register(Employer employer, String passwordAgain );

	DataResult<List<Employer>> getAll();
	
	DataResult<Employer> getByEmail(String email);
	
	DataResult<Employer> getById(int id);
	
	DataResult<Employer> getByCompanyName(String companyName);
	
	DataResult<List<Employer>> getByCompanyNameContains(String companyName);
	
	DataResult<List<Employer>> getByCompanyNameStartsWith(String companyName);
	
	Result activateAccountByEmail(String email,String code);

	
	

}
