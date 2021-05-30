package Kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.hrms.business.abstracts.EmployerService;
import Kodlama.io.hrms.business.abstracts.Employer_ConfirmationService;
import Kodlama.io.hrms.core.utilities.results.DataResult;
import Kodlama.io.hrms.core.utilities.results.Result;
import Kodlama.io.hrms.entities.concretes.Employer;
import Kodlama.io.hrms.entities.concretes.Employer_Confirmation;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
	
	private EmployerService employerService;
	private Employer_ConfirmationService employer_ConfirmationService;

	@Autowired
	public EmployersController(EmployerService employerService,
			Employer_ConfirmationService employer_ConfirmationService) {
		super();
		this.employerService = employerService;
		this.employer_ConfirmationService = employer_ConfirmationService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}
	
	@GetMapping("/getByEmail")
	public DataResult<Employer> getByEmail(String email){
		return this.employerService.getByEmail(email);
	}
	
	@GetMapping("/getById")
	public DataResult<Employer> getById(int id){
		return this.employerService.getById(id);
	}
	
	@GetMapping("/getByCompanyName")
	public DataResult<Employer> getByCompanyName(String companyName){
		return this.getByCompanyName(companyName);
	}
	
	@GetMapping("/getByCompanyNameContains")
	public DataResult<List<Employer>> getByCompanyNameContains(String companyName){
		return this.employerService.getByCompanyNameContains(companyName);
	}
	
	@GetMapping("/getByCompanyNameStartsWith")
	public DataResult<List<Employer>> getByCompanyNameStartsWith(String companyName){
		return this.employerService.getByCompanyNameStartsWith(companyName);
	}
	
	@PostMapping("/activateAccountByEmail")
	public Result activateAccountByEmail(String email, String code) {
		return this.employerService.activateAccountByEmail(email, code);
	}
	
	@PostMapping("/register")
	public Result register(Employer employer, String passwordAgain) {

		return this.employerService.register(employer, passwordAgain);
	}
	
	@GetMapping("/findByConfirmatedFalse")
	public DataResult<List<Employer_Confirmation>> findByConfirmatedFalse(){
		return this.employer_ConfirmationService.findByConfirmatedFalse();
	}
	
	@PostMapping("/confirmateEmployer")
	public Result confirmateEmployer(int id, int staffId) {
		return this.employer_ConfirmationService.confirmateEmployer(id, staffId);
	}
	
	
	
}
