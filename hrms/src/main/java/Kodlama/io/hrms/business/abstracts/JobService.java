package Kodlama.io.hrms.business.abstracts;

import java.util.List;

import Kodlama.io.hrms.entities.concretes.Job;

public interface JobService {
	List<Job> getAll();
}
