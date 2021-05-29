package Kodlama.io.hrms.core.utilities.verify.email;

import org.springframework.stereotype.Service;

import Kodlama.io.hrms.core.utilities.results.ErrorResult;
import Kodlama.io.hrms.core.utilities.results.Result;
import Kodlama.io.hrms.core.utilities.results.SuccessResult;
import Kodlama.io.hrms.email.EmailPostService;

@Service
public class EmailPostingAdaptor implements EmailService {

	private EmailPostService emailPostService=new EmailPostService();

	@Override
	public Result SendEmail(String toEmail, String body) {
		
		boolean sendMail=this.emailPostService.SendEmail(toEmail, "hrms_verify@hrms.com", "Account Verficiation Code", body);
		
			
		if (sendMail) {
			return new SuccessResult(toEmail + " adresine Doğrulama kodu gönderildi");
		}
		return new ErrorResult(toEmail + " adresine Doğrulama kodu gönderilemedi!");
	}
	

	

}
