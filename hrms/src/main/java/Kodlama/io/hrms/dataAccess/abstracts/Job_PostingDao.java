package Kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Kodlama.io.hrms.entities.concretes.Job_Posting;
import Kodlama.io.hrms.entities.dtos.JobPostingDto;

@Repository
public interface Job_PostingDao extends JpaRepository<Job_Posting, Integer>{

	Job_Posting getById(int id);
	
	List<Job_Posting> getByJob_JobId(int jobId);
	
	List<Job_Posting> getByEmployer_Id(int employerId);
	
	List<Job_Posting> getByCity_Id(int cityId);
	
	List<Job_Posting> getByJobDetailContains(String details);
	
	List<Job_Posting> getByActive(boolean active);
	
//	@Query("Select new Kodlama.io.hrms.entities.dtos.JobPostingDto"
//			+ "(jp.id,jp.openPosition,jp.dateOfPublish,jp.deadline)"
//			+ "From Job_Posting jp ")
////			+ "Inner Join jp.employer emp")
////			+ "Inner Join jp.job jb")
	@Query("Select new Kodlama.io.hrms.entities.dtos.JobPostingDto"
			+ "(jp.id,emp.companyName,j.title,jp.openPosition,jp.dateOfPublish,jp.deadline)"
			+ "From Job_Posting jp Inner Join jp.employer emp Inner Join jp.job j")
	List<JobPostingDto> getByActivePostings();
	
	
}
