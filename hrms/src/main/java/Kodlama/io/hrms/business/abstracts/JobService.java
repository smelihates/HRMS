package Kodlama.io.hrms.business.abstracts;

import java.util.List;

import Kodlama.io.hrms.core.utilities.results.DataResult;
import Kodlama.io.hrms.core.utilities.results.Result;
import Kodlama.io.hrms.entities.concretes.Job;


public interface JobService {
	
	DataResult<Job> getByJobId(int jobId);
	
	DataResult<Job> getByTitle(String title);
	
	DataResult<List<Job>> getByUserId(int userId);
	
	DataResult<List<Job>> getAll();
	
	DataResult<List<Job>>  getByTitleContains(String title);
	
	DataResult<List<Job>>  getByTitleStartsWith(String title);
	
	Result add(Job job);
	
	
}
