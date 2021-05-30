package Kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.hrms.business.abstracts.Employer_ConfirmationService;
import Kodlama.io.hrms.core.utilities.results.DataResult;
import Kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import Kodlama.io.hrms.core.utilities.results.ErrorResult;
import Kodlama.io.hrms.core.utilities.results.Result;
import Kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import Kodlama.io.hrms.core.utilities.results.SuccessResult;
import Kodlama.io.hrms.dataAccess.abstracts.Employer_ConfirmationDao;
import Kodlama.io.hrms.entities.concretes.Employer_Confirmation;

@Service
public class Employer_ConfirmationManager implements Employer_ConfirmationService {

	private Employer_ConfirmationDao employer_ConfirmationDao; 
	
	@Autowired
	public Employer_ConfirmationManager(Employer_ConfirmationDao employer_ConfirmationDao) {
		super();
		this.employer_ConfirmationDao = employer_ConfirmationDao;
	}

	
	@Override
	public Result register(int id) {

		Employer_Confirmation confirmation=new Employer_Confirmation(id,false);
		
		this.employer_ConfirmationDao.save(confirmation);

		return new SuccessResult("Şirket doğrulaması için Personel onayı bekliyor!");
	}

	@Override
	public DataResult<Employer_Confirmation> getById(int id) {
		var result=this.employer_ConfirmationDao.getById(id);
		if(result.getId()>0) {
			return new ErrorDataResult<Employer_Confirmation>("Veri kaydı yok!");
		}

		return new SuccessDataResult<Employer_Confirmation>
		(this.employer_ConfirmationDao.getById(id));
	}

	@Override
	public Result confirmateEmployer(int id, int staffId) {
		if(id>0 && staffId>0) {
			Employer_Confirmation confirmation=new Employer_Confirmation();
			confirmation=this.employer_ConfirmationDao.getById(id);
			
			if(confirmation.getConfirmated()==true) {
				return new ErrorResult("Daha önce doğrulama yapılmış!");
			}
			
			confirmation.setConfirmated(true);
			confirmation.setConfirmatedByStaffId(staffId);
			this.employer_ConfirmationDao.save(confirmation);
			return new SuccessResult("Şirket Doğrulaması başarılı bir şekilde yapıldı.");
			
		}
		return new ErrorResult("Geçerli bir Şirket Id ve Staff Id girin!");
	}
	
	@Override
	public DataResult<List<Employer_Confirmation>> findByConfirmatedFalse(){
		
		return new SuccessDataResult<List<Employer_Confirmation>>
		(this.employer_ConfirmationDao.findByConfirmatedFalse());
	}

}
