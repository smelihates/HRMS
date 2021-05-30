package Kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.hrms.business.abstracts.Email_VerificationService;
import Kodlama.io.hrms.business.abstracts.EmployerService;
import Kodlama.io.hrms.business.abstracts.Employer_ConfirmationService;
import Kodlama.io.hrms.core.utilities.results.DataResult;
import Kodlama.io.hrms.core.utilities.results.ErrorResult;
import Kodlama.io.hrms.core.utilities.results.Result;
import Kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import Kodlama.io.hrms.core.utilities.results.SuccessResult;
import Kodlama.io.hrms.core.utilities.validation.ValidationService;
import Kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import Kodlama.io.hrms.entities.concretes.Employer;
import Kodlama.io.hrms.entities.concretes.Employer_Confirmation;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private ValidationService validationService;
	private Email_VerificationService email_VerificationService;
	private Employer_ConfirmationService employer_ConfirmationService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,
			ValidationService validationService,
			Email_VerificationService email_VerificationService,
			Employer_ConfirmationService employer_ConfirmationService) {
		super();
		this.employerDao = employerDao;
		this.email_VerificationService=email_VerificationService;
		this.validationService=validationService;
		this.employer_ConfirmationService=employer_ConfirmationService;
	}

	@Override
	public Result register(Employer employer, String passwordAgain) {
		
		String message="";
		
		
		Result result=this.validationService.validateBlankField(employer.getCompanyName());
		
		if(!result.isSuccess()) {
			message += employer.getCompanyName() + " " +result.getMessage() +"\n";
		}
		
		result=this.validationService.validateBlankField(employer.getWebAddress());
		
		if(!result.isSuccess()) {
			message += employer.getWebAddress() + " " +result.getMessage() +"\n";
		}

		result=this.validationService.validateBlankField(employer.getEmail());
		
		if(!result.isSuccess()) {
			message += employer.getEmail() + " " +result.getMessage() +"\n";
		}
		
		result=this.validationService.validateBlankField(employer.getPhoneNo());
		
		if(!result.isSuccess()) {
			message += employer.getPhoneNo()+ " " +result.getMessage() +"\n";
		}
		
		result=this.validationService.validateEmail(employer.getEmail());
		
		if(!result.isSuccess()) {
			message += employer.getEmail() + " " +result.getMessage() +"\n";
		}
		
		result=this.validationService.validatePassword(employer.getPassword(),passwordAgain);

		if(!result.isSuccess()) {
			message += employer.getPassword() + " " +result.getMessage() +"\n";
		}
		
		result=this.validationService.validateEmailWebAddressDomain(employer.getEmail(), employer.getWebAddress());

		if(!result.isSuccess()) {
			message += employer.getWebAddress() +"-"+ employer.getEmail() + " " +result.getMessage() +"\n";
		}
		
		if(message.length()>0) {
			return new ErrorResult(message);
		}

		this.employerDao.save(employer);
		message="Şirket kayıt edildi.";
		
		message+=this.email_VerificationService.register(employer.getId()).getMessage();
		
		message+=this.employer_ConfirmationService.register(employer.getId()).getMessage();
		
		return new SuccessResult(message);
	}

	@Override
	public DataResult<List<Employer>> getAll(){
		
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.findAll(),"Şirketler listelendi.");
	}
	
	@Override
	public DataResult<Employer> getByEmail(String email) {

		return new SuccessDataResult<Employer>
		(this.employerDao.getByEmail(email),"Şirket bilgisi getirildi.");
	}
	
	@Override
	public DataResult<Employer> getById(int id) {
		
		return new SuccessDataResult<Employer>
		(this.employerDao.getById(id),"Şirket bilgileri getirildi.");
	}

	@Override
	public DataResult<Employer> getByCompanyName(String companyName) {
		
		return new SuccessDataResult<Employer>
		(this.employerDao.getByCompanyName(companyName),"Şirket bilgileri getirildi.");
	}

	@Override
	public DataResult<List<Employer>> getByCompanyNameContains(String companyName) {
		
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.getByCompanyNameContains(companyName),"Şirketler listelendi.");
	}

	@Override
	public DataResult<List<Employer>> getByCompanyNameStartsWith(String companyName) {
		
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.getByCompanyNameStartsWith(companyName),"Şirketler listelendi.");
	}

	@Override
	public Result activateAccountByEmail(String email, String code) {
		var result=this.email_VerificationService.setValidate
				(this.employerDao.getByEmail(email).getId(), code);
		
		if(result.isSuccess()) {
				return new SuccessResult(result.getMessage());
		}
		
		return new ErrorResult(result.getMessage());
	}

	@Override
	public Result activateAccountByStaff(int id, int staffId) {

		var result =this.employer_ConfirmationService.confirmate(id, staffId);

		if(result.isSuccess()) {
			return new SuccessResult(result.getMessage());
		}
		return new ErrorResult(result.getMessage());
	}
	

	

}
