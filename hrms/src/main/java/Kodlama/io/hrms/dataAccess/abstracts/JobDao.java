package Kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Kodlama.io.hrms.entities.concretes.Job;

@Repository
public interface JobDao extends JpaRepository<Job, Integer>{

	Job getByJobId(int jobId);
	
	Job getByTitle(String title);
	
	List<Job> getByUserId(int userId);
	
	List<Job> getByTitleContains(String title);
	
	List<Job> getByTitleStartsWith(String title);
}
