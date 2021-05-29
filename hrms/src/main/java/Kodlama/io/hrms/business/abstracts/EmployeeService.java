package Kodlama.io.hrms.business.abstracts;

import java.util.List;

import Kodlama.io.hrms.core.utilities.results.DataResult;
import Kodlama.io.hrms.core.utilities.results.Result;
import Kodlama.io.hrms.entities.concretes.Employee;

public interface EmployeeService {
	
	DataResult<List<Employee>>  getAll();
	
	Result register(Employee employee, String passwordAgain);
	
	DataResult<Employee> getByTcNo(String tcNo);
	
	DataResult<Employee>  getById(int id);
	
	DataResult<Employee>  getByEmail(String email);
	
	Result activateAccount(String email,String code);
}
