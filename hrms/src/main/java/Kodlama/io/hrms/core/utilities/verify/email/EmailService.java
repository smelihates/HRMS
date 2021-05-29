package Kodlama.io.hrms.core.utilities.verify.email;

import Kodlama.io.hrms.core.utilities.results.Result;

public interface EmailService {

	Result SendEmail(String toEmail, String body);
}
