package Kodlama.io.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.hrms.business.abstracts.Email_VerificationService;
import Kodlama.io.hrms.business.abstracts.EmployeeService;
import Kodlama.io.hrms.core.utilities.results.DataResult;

import Kodlama.io.hrms.core.utilities.results.ErrorResult;
import Kodlama.io.hrms.core.utilities.results.Result;
import Kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import Kodlama.io.hrms.core.utilities.results.SuccessResult;
import Kodlama.io.hrms.core.utilities.validation.ValidationService;
import Kodlama.io.hrms.dataAccess.abstracts.EmployeeDao;
import Kodlama.io.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{

	private EmployeeDao employeeDao;
	private ValidationService validationService;
	private Email_VerificationService email_VerificationService;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao,
			ValidationService validationService,
			Email_VerificationService email_VerificationService) {
		super();
		this.employeeDao = employeeDao;
		this.validationService=validationService;
		this.email_VerificationService=email_VerificationService;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		
		return new SuccessDataResult<List<Employee>>
		(this.employeeDao.findAll(),"Adaylar Listelendi.");
	}

	@Override
	public Result register(Employee employee, String passwordAgain) {

		String message="";
		
		Result result=this.validationService.validateBlankField(employee.getFirstName());
		
		if(!result.isSuccess()) {
			message += employee.getFirstName() + " " +result.getMessage() +"\n";
		}
		
		
		result=this.validationService.validateBlankField(employee.getSurName());
		
		if(!result.isSuccess()) {
			message += employee.getSurName() + " " +result.getMessage() +"\n";
		}
		
		result=this.validationService.validateBlankField(employee.getBirthDate());
		
		if(!result.isSuccess()) {
			message += employee.getBirthDate() + " " +result.getMessage() +"\n";
		}
		
		result=this.validationService.validateEmail(employee.getEmail());
		
		if(!result.isSuccess()) {
			message += employee.getEmail() + " " +result.getMessage() +"\n";
		}
		
		result=this.validationService.validateIdentifyNumber
				(employee.getFirstName(),employee.getSurName(),employee.getTcNo(),employee.getBirthDate());
		
		if(!result.isSuccess()) {
			message += employee.getTcNo() + " " +result.getMessage() +"\n";
		}
		
		result=this.validationService.validatePassword(employee.getPassword(),passwordAgain);

		if(!result.isSuccess()) {
			message += employee.getPassword() + " " +result.getMessage() +"\n";
		}
		
		
		if(message.length()>0) {
			return new ErrorResult(message);
		}
		
				this.employeeDao.save(employee);
				message="Aday kayıt edildi." +" ";
				message+=this.email_VerificationService.register(employee.getId()).getMessage();
				
				return new SuccessResult(message);
	}

	@Override
	public DataResult<Employee> getByTcNo(String tcNo) {

		return new SuccessDataResult<Employee>
		(this.employeeDao.getByTcNo(tcNo),"Aday bilgisi getirildi.");
	}

	@Override
	public DataResult<Employee> getById(int id) {

		return new SuccessDataResult<Employee>
		(this.employeeDao.getById(id),"Aday bilgisi getirildi.");
	}

	@Override
	public DataResult<Employee> getByEmail(String email) {

		return new SuccessDataResult<Employee>
		(this.employeeDao.getByEmail(email),"Aday bilgisi getirildi.");
	}

	@Override
	public Result activateAccountByEmail(String email,String code) {
		
		var result=this.email_VerificationService.setValidate
				(this.employeeDao.getByEmail(email).getId(), code);
		
		if(result.isSuccess()) {
				return new SuccessResult(result.getMessage());
		}
		
		return new ErrorResult(result.getMessage());
		
	}
	
}
