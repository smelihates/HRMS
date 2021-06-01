package Kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Kodlama.io.hrms.business.abstracts.Job_PostingService;
import Kodlama.io.hrms.core.utilities.results.DataResult;
import Kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import Kodlama.io.hrms.core.utilities.results.ErrorResult;
import Kodlama.io.hrms.core.utilities.results.Result;
import Kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import Kodlama.io.hrms.core.utilities.results.SuccessResult;
import Kodlama.io.hrms.dataAccess.abstracts.Job_PostingDao;
import Kodlama.io.hrms.entities.concretes.Job_Posting;
import Kodlama.io.hrms.entities.dtos.JobPostingDto;

@Service
public class Job_PostingManager implements Job_PostingService{

	private Job_PostingDao job_PostingDao;
	
	@Autowired
	public Job_PostingManager(Job_PostingDao job_PostingDao) {
		super();
		this.job_PostingDao = job_PostingDao;
	}

	@Override
	public Result add(Job_Posting jobPosting) {
		
		System.out.println(jobPosting);
		this.job_PostingDao.save(jobPosting);
		return new SuccessResult("İlan sisteme eklendi");
	}

	@Override
	public DataResult<Job_Posting> getById(int id) {
		var result=this.job_PostingDao.getById(id);
		
		if(result==null) {
			return new ErrorDataResult<Job_Posting>
			("Kayıt yok!");
		}
		
			return new SuccessDataResult<Job_Posting>
			(result,"İlan bilgileri getirildi.");
			
		
		
		
	}

	@Override
	public DataResult<List<Job_Posting>> getByJob_JobId(int jobId) {
		
		return new SuccessDataResult<List<Job_Posting>>
		(this.job_PostingDao.getByJob_JobId(jobId),"İlanlar listelendi.");
	}

	@Override
	public DataResult<List<Job_Posting>> getByEmployer_Id(int employerId) {
		
		return new SuccessDataResult<List<Job_Posting>>
		(this.job_PostingDao.getByEmployer_Id(employerId),"İlanlar listelendi.");
	}

	@Override
	public DataResult<List<Job_Posting>> getByCity_Id(int cityId) {

		return new SuccessDataResult<List<Job_Posting>>
		(this.job_PostingDao.getByCity_Id(cityId),"İlanlar listelendi.");
	}

	@Override
	public DataResult<List<Job_Posting>> getByJobDetailContains(String details) {
		
		return new SuccessDataResult<List<Job_Posting>>
		(this.job_PostingDao.getByJobDetailContains(details),"İlanlar listelendi.");
	}

	@Override
	public DataResult<List<Job_Posting>> getByActiveJobPostingsDetail() {

		return new SuccessDataResult<List<Job_Posting>>
		(this.job_PostingDao.getByActive(true),"İlanlar listelendi.");
	}

	@Override
	public Result passive(int id) {
		
		Job_Posting job_Posting=this.job_PostingDao.getById(id);
		
		if(job_Posting.isActive()==false) {
			return new ErrorResult("İlan daha önce pasif yapılmış!");
		}
		
		job_Posting.setActive(false);
		this.job_PostingDao.save(job_Posting);
		
		return new SuccessResult("İlan pasif yapıldı.");
	}

	@Override
	public DataResult<List<JobPostingDto>> getByActivePostings() {
		
		return new SuccessDataResult<List<JobPostingDto>>
		(this.job_PostingDao.getByActivePostings(),"Aktif ilanlar listelendi.");
	}

	@Override
	public DataResult<List<JobPostingDto>> getByActivePostingsPublishDesc() {
		
		return new SuccessDataResult<List<JobPostingDto>>
		(this.job_PostingDao.getByActivePostingsPublishDesc(),"Aktif ilanlar Tarihe göre listelendi.");
	}
	
	
}
