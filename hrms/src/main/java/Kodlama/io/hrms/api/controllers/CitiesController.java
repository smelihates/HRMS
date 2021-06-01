package Kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.hrms.business.abstracts.CityService;
import Kodlama.io.hrms.core.utilities.results.DataResult;
import Kodlama.io.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {

	private CityService cityService;

	@Autowired
	public CitiesController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@GetMapping("/getById")
	public DataResult<City> getById(int id) {
		return this.cityService.getById(id);
	}
	
	@GetMapping("/getByCity")
	public DataResult<City> getByCity(String city) {
		return this.cityService.getByCity(city);
	}
	
	@GetMapping("/getByCityContains")
	public DataResult<List<City>> getByCityContains(String city) {
		return this.cityService.getByCityContains(city);
	}
	
	@GetMapping("/getByCityStartsWith")
	public DataResult<List<City>> getByCityStartsWith(String city) {
		return this.cityService.getByCityStartsWith(city);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<City>> getAll() {
		return this.cityService.getAll();
	}
	
}
