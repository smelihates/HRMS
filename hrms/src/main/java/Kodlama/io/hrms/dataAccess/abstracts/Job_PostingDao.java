package Kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Kodlama.io.hrms.entities.concretes.Job_Posting;

@Repository
public interface Job_PostingDao extends JpaRepository<Job_Posting, Integer>{

	Job_Posting getById(int id);
	
	List<Job_Posting> getByJob_JobId(int jobId);
	
	List<Job_Posting> getByEmployer_Id(int employerId);
	
	List<Job_Posting> getByCity_Id(int cityId);
	
	List<Job_Posting> getByJobDetailContains(String details);
	
	List<Job_Posting> getByActive(boolean active);
}
