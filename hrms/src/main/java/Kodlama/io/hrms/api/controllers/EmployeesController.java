package Kodlama.io.hrms.api.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.hrms.business.abstracts.EmployeeService;
import Kodlama.io.hrms.core.utilities.results.DataResult;
import Kodlama.io.hrms.core.utilities.results.Result;
import Kodlama.io.hrms.entities.concretes.Employee;


@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	
	@GetMapping("/getAll")
	public DataResult<List<Employee>> getAll() {

		return this.employeeService.getAll();
	}
	
	@GetMapping("/getByTcNo")
	public DataResult<Employee> getByTcNo(@RequestParam String tcNo) {

		return this.employeeService.getByTcNo(tcNo);
	}

	@GetMapping("/getById")
	public DataResult<Employee> getById(@RequestParam int id) {
	
		return this.employeeService.getById(id);
	}
	
	@GetMapping("/getByEmail")
	public DataResult<Employee> getByEmail(@RequestParam String email) {
		
		return this.employeeService.getByEmail(email);
	}
	
	@PostMapping("/register")
	public Result register(Employee employee, @RequestParam String passwordAgain) {
		
		return this.employeeService.register(employee, passwordAgain);
	}
	
	@PostMapping("/activateAccount")
	public Result activateAccount(@RequestParam String email,@RequestParam String code) { 
		
		return this.employeeService.activateAccount(email, code);
	}
}
