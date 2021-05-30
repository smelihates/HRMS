package Kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.hrms.business.abstracts.JobService;
import Kodlama.io.hrms.core.utilities.results.DataResult;
import Kodlama.io.hrms.core.utilities.results.ErrorResult;
import Kodlama.io.hrms.core.utilities.results.Result;
import Kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import Kodlama.io.hrms.core.utilities.results.SuccessResult;
import Kodlama.io.hrms.dataAccess.abstracts.JobDao;
import Kodlama.io.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}


	@Override
	public DataResult<Job> getByJobId(int jobId) {
		
		return new SuccessDataResult<Job>
		(this.jobDao.getByJobId(jobId),"İşler listelendi");
	}

	@Override
	public DataResult<Job> getByTitle(String title) {
		
		return new SuccessDataResult<Job>
		(this.jobDao.getByTitle(title),"İş listelendi");
	}

	@Override
	public DataResult<List<Job>> getByUserId(int userId) {
		 
		return new SuccessDataResult<List<Job>>
		(this.jobDao.getByUserId(userId),"İşler listelendi");
	}

	@Override
	public DataResult<List<Job>> getAll() {
		 
		return new SuccessDataResult<List<Job>>
		(this.jobDao.findAll(),"İşler listelendi");
	}

	@Override
	public DataResult<List<Job>> getByTitleContains(String title) {
		
		return new SuccessDataResult<List<Job>>
		(this.jobDao.getByTitleContains(title),"İşler listelendi");
	}

	@Override
	public DataResult<List<Job>> getByTitleStartsWith(String title) {
		
		return new SuccessDataResult<List<Job>>
		(this.jobDao.getByTitleStartsWith(title),"İşler listelendi");
	}

	@Override
	public Result add(Job job) {
		
		System.out.println(job);
		
		System.out.println(this.jobDao.getByTitle(job.getTitle()));

		if(this.jobDao.getByTitle(job.getTitle())==null ) {
			this.jobDao.save(job);
			return new SuccessResult("Pozisyon eklendi");
		}else if(this.jobDao.getByTitle(job.getTitle()).getTitle().equals(job.getTitle())) {
			return new ErrorResult("Pozisyon ismi daha önce kayıt edilmiş! Değiştirin.");
		}
			
		return new ErrorResult();
	}

}
