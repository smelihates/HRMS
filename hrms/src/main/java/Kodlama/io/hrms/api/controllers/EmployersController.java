package Kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.hrms.business.abstracts.EmployerService;
import Kodlama.io.hrms.core.utilities.results.DataResult;
import Kodlama.io.hrms.core.utilities.results.Result;
import Kodlama.io.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
	
	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
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
	
}
