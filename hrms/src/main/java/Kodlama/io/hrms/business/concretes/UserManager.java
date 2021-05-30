package Kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.hrms.business.abstracts.UserService;
import Kodlama.io.hrms.core.utilities.results.DataResult;
import Kodlama.io.hrms.core.utilities.results.ErrorResult;
import Kodlama.io.hrms.core.utilities.results.Result;
import Kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import Kodlama.io.hrms.core.utilities.results.SuccessResult;
import Kodlama.io.hrms.dataAccess.abstracts.UserDao;
import Kodlama.io.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {

		return new SuccessDataResult<List<User>>
		(this.userDao.findAll(),"Kullanıcılar listelendi.");
	}

	@Override
	public DataResult<User> getById(int id) {
		
		return new SuccessDataResult<User>
		(this.userDao.getById(id),"Kullanıcı bilgisi getirildi.");
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<User>
		(this.userDao.getByEmail(email),"Kullanıcı bilgisi getirildi.");

	}
	
	@Override
	public Result isEmail(String email) {

		//System.out.println(this.userDao.findByEmail(email));
		if (this.userDao.findByEmail(email)==null) {
			return new SuccessResult();
		}
		return new ErrorResult("Bu email adresi sistemde kayıtlı!");
	}
	
	
	
}
