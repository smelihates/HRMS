package Kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Kodlama.io.hrms.entities.concretes.City;

@Repository
public interface CityDao extends JpaRepository<City, Integer>{

	City getById(int id);
	
	City getByCity(String city);
	
	List<City> getByCityContains(String city);
	
	List<City> getByCityStartsWith(String city);
	
}
