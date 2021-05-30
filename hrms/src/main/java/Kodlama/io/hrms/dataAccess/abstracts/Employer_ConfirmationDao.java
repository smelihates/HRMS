package Kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Kodlama.io.hrms.entities.concretes.Employer_Confirmation;

@Repository
public interface Employer_ConfirmationDao extends JpaRepository<Employer_Confirmation,Integer>{
	
	Employer_Confirmation getById(int id);
	
	List<Employer_Confirmation> findByConfirmatedFalse();
	
	
}
