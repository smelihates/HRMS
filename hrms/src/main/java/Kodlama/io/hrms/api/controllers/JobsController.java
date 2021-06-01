package Kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.hrms.business.abstracts.JobService;
import Kodlama.io.hrms.core.utilities.results.DataResult;
import Kodlama.io.hrms.core.utilities.results.Result;
import Kodlama.io.hrms.entities.concretes.Job;

@RestController
@RequestMapping("/api/jobs")
public class JobsController {

	private JobService jobService;

	@Autowired
	public JobsController(JobService jobService) {
		super();
		this.jobService = jobService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Job>> getAll() {
		return this.jobService.getAll();
	}
	
	@GetMapping("/getByJobId")
	public DataResult<Job> getByJobId(int jobId) {
		return this.jobService.getByJobId(jobId);
	}
	
	@GetMapping("/getByTitle")
	public DataResult<Job> getByTitle(String title) {
		return this.jobService.getByTitle(title);
	}
	
	@GetMapping("/getByUserId")
	public DataResult<List<Job>> getByUserId(int userId) {
		return this.jobService.getByUserId(userId);
	}
	
	@GetMapping("/getByTitleContains")
	public DataResult<List<Job>> getByTitleContains(String title) {
		return this.jobService.getByTitleContains(title);
	}
	
	@GetMapping("/getByTitleStartsWith")
	public DataResult<List<Job>> getByTitleStartsWith(String title) {
		return this.jobService.getByTitleStartsWith(title);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Job job) {

		return this.jobService.add( job);
	}
	
}
