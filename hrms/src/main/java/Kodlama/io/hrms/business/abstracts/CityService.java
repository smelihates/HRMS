package Kodlama.io.hrms.business.abstracts;

import java.util.List;

import Kodlama.io.hrms.core.utilities.results.DataResult;

import Kodlama.io.hrms.entities.concretes.City;

public interface CityService {

	DataResult<City> getById(int id);
	
	DataResult<City>  getByCity(String city);
	
	DataResult<List<City>> getByCityContains(String city);
	
	DataResult<List<City>> getByCityStartsWith(String city);
	
	DataResult<List<City>> getAll();
	

}
