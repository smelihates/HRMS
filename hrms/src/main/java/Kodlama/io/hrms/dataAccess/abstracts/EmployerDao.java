package Kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Kodlama.io.hrms.entities.concretes.Employer;


@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer> {

	Employer getById(int id);
	
	Employer getByEmail(String email);
	
	Employer getByCompanyName(String companyName);
	
	List<Employer> getByCompanyNameContains(String companyName);
	
	List<Employer> getByCompanyNameStartsWith(String companyName);
	
}
