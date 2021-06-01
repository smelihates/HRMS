package Kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.hrms.business.abstracts.Job_PostingService;
import Kodlama.io.hrms.core.utilities.results.DataResult;
import Kodlama.io.hrms.core.utilities.results.Result;
import Kodlama.io.hrms.entities.concretes.Job_Posting;

@RestController
@RequestMapping("api/jobPostings")
public class JobPostingsController {

	private Job_PostingService job_PostingService;
	
	@Autowired
	public JobPostingsController(Job_PostingService job_PostingService) {
		super();
		this.job_PostingService = job_PostingService;
	}
	
	@GetMapping("/getById")
	public DataResult<Job_Posting> getById(int id) {
		return this.job_PostingService.getById(id);
	}
	
	@GetMapping("/getByJobId")
	public DataResult<List<Job_Posting>> getByJob_JobId(int jobId) {
		return this.job_PostingService.getByJob_JobId(jobId);
	}
	
	@GetMapping("/getByEmployerId")
	public DataResult<List<Job_Posting>> getByEmployer_Id(int employerId) {
		return this.job_PostingService.getByEmployer_Id(employerId);
	}
	
	@GetMapping("/getByCityId")
	public DataResult<List<Job_Posting>> getByCity_Id(int cityId) {
		return this.job_PostingService.getByCity_Id(cityId);
	}
	
	@GetMapping("/getByJobDetailContains")
	public DataResult<List<Job_Posting>> getByJobDetailContains(String details) {
		return this.job_PostingService.getByJobDetailContains(details);
	}
	
	@GetMapping("/getByActiveJobPostings")
	public DataResult<List<Job_Posting>> getByActiveJobPostings(boolean active) {
		return this.job_PostingService.getByActiveJobPostings();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Job_Posting jobPosting) {
		return this.job_PostingService.add(jobPosting);
	}
	
	@PostMapping("/passive")
	public Result passive(int id) {
		return this.job_PostingService.passive(id);
	}
	
}
