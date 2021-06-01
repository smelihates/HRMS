package Kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.hrms.business.abstracts.CityService;
import Kodlama.io.hrms.core.utilities.results.DataResult;
import Kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import Kodlama.io.hrms.dataAccess.abstracts.CityDao;
import Kodlama.io.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService {

	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<City> getById(int id) {

		return new SuccessDataResult<City>
		(this.cityDao.getById(id));
	}

	@Override
	public DataResult<City> getByCity(String city) {

		return new SuccessDataResult<City>
		(this.cityDao.getByCity(city));
	}

	@Override
	public DataResult<List<City>> getByCityContains(String city) {

		return new SuccessDataResult<List<City>>
		(this.cityDao.getByCityContains(city));
	}

	@Override
	public DataResult<List<City>> getByCityStartsWith(String city) {

		return new SuccessDataResult<List<City>>
		(this.cityDao.getByCityStartsWith(city));
	}

	@Override
	public DataResult<List<City>> getAll() {

		return new SuccessDataResult<List<City>>
		(this.cityDao.findAll());
	}

	

}
