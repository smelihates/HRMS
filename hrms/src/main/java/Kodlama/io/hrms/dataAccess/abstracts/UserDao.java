package Kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;


import Kodlama.io.hrms.entities.concretes.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
	User getById(int id);
	
	
	User getByEmail(String email);
	
	@Nullable
	User findByEmail(@Nullable String email);

	
}
