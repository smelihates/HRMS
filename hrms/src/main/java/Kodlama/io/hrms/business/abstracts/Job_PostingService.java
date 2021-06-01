package Kodlama.io.hrms.business.abstracts;

import java.util.List;

import Kodlama.io.hrms.core.utilities.results.DataResult;
import Kodlama.io.hrms.core.utilities.results.Result;
import Kodlama.io.hrms.entities.concretes.Job_Posting;

public interface Job_PostingService {

	Result add(Job_Posting jobPosting);
	
	DataResult<Job_Posting> getById(int id);
	
	DataResult<List<Job_Posting>> getByJob_JobId(int jobId);
	
	DataResult<List<Job_Posting>> getByEmployer_Id(int employerId);
	
	DataResult<List<Job_Posting>> getByCity_Id(int cityId);
	
	DataResult<List<Job_Posting>> getByJobDetailContains(String details);
	
	DataResult<List<Job_Posting>> getByActiveJobPostings();
	
	Result passive(int id);
}
