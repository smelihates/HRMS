package Kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.hrms.entities.concretes.Email_Verification;

public interface Email_VerificationDao extends JpaRepository<Email_Verification, Integer> {

	Email_Verification getById(int id);
	
	
}
