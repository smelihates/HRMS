package Kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.hrms.business.abstracts.Email_VerificationService;
import Kodlama.io.hrms.business.abstracts.HashCodeService;
import Kodlama.io.hrms.core.utilities.results.DataResult;
import Kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import Kodlama.io.hrms.core.utilities.results.ErrorResult;
import Kodlama.io.hrms.core.utilities.results.Result;
import Kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import Kodlama.io.hrms.core.utilities.results.SuccessResult;
import Kodlama.io.hrms.core.utilities.verify.email.EmailService;
import Kodlama.io.hrms.dataAccess.abstracts.Email_VerificationDao;
import Kodlama.io.hrms.dataAccess.abstracts.UserDao;
import Kodlama.io.hrms.entities.concretes.Email_Verification;


@Service
public class Email_VerificationManager implements Email_VerificationService{


	private Email_VerificationDao email_VerificationDao;
	private UserDao userDao;
	private HashCodeService hashCodeService;
	private EmailService emailService;
	
	@Autowired	
	public Email_VerificationManager(Email_VerificationDao email_VerificationDao, UserDao userDao,
			HashCodeService hashCodeService, EmailService emailService) {
		super();
		this.email_VerificationDao = email_VerificationDao;
		this.userDao = userDao;
		this.hashCodeService = hashCodeService;
		this.emailService = emailService;
	}
	
	
	@Override
	public Result register(int id) {
				
//		//Email_Verification verification1 = new Email_Verification();
//		var verification1=this.email_VerificationDao.getById(id);
//		
//		System.out.println(verification1);
//		
//		if(verification1==null) {
			String code=this.hashCodeService.generateCode();
			
			Email_Verification verification2 = new Email_Verification(id,code,false);
			
			System.out.println(verification2);
			this.email_VerificationDao.save(verification2);
		
			String toEmail=this.userDao.getById(id).getEmail();
			this.emailService.SendEmail(toEmail, code);
			
			return new SuccessResult("Doğrulama kodu email adresine gönderildi.");
//		}
//		
//		if(verification1.getVerified()==true) {
//			return new ErrorResult("Daha önce doğrulama yapılmış!");
//		}
//		
//		if(verification1.getId()==id) {
//			return new ErrorResult("Daha önce kayıt yapılmış!");
//		}	
//		
//		return new ErrorResult();

	}
	@Override
	public DataResult<Email_Verification> getById(int id) {
		var result=this.email_VerificationDao.getById(id);
		if(result.getId()>0) {
			return new ErrorDataResult<Email_Verification>("Veri kaydı yok!");
		}
			
		return new SuccessDataResult<Email_Verification>
		(this.email_VerificationDao.getById(id));
	}

	@Override
	public Result setValidate(int id, String code) {
		
		System.out.println("id : " +id);
		System.out.println("code : " +code);
		if(code.isEmpty()) {
			return new ErrorResult("Doğrulama kodu boş olamaz!");
		}
		
		Email_Verification verification = new Email_Verification();
		verification=this.email_VerificationDao.getById(id);
		System.out.println(verification);
		
		if(verification.getVerified()==true) {
			return new ErrorResult("Daha önce doğrulama yapılmış!");
		}
		
		if(verification.getCode().equals(code)) {
			verification.setVerified(true);
			this.email_VerificationDao.save(verification);
			return new SuccessResult("Doğrulama başarılı bir şekilde yapıldı.");

		}
		
		return new ErrorResult("Doğrulama kodu hatalı!");
			
	}

	


	


}
