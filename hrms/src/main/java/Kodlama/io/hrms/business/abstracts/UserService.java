package Kodlama.io.hrms.business.abstracts;

import java.util.List;

import Kodlama.io.hrms.core.utilities.results.DataResult;
import Kodlama.io.hrms.core.utilities.results.Result;
import Kodlama.io.hrms.entities.concretes.User;

public interface UserService {

	DataResult<List<User>>  getAll();
	
	DataResult<User> getById(int id);
	
	DataResult<User> getByEmail(String email);
	
	Result isEmail(String email);
}
