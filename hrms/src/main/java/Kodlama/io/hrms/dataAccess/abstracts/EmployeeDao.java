package Kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Kodlama.io.hrms.entities.concretes.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	
	Employee getByTcNo(String tcNo);
	
	Employee getById(int id);
	
	Employee getByEmail(String email);
	
	
}
