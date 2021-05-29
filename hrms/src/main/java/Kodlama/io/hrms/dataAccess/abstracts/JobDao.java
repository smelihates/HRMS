package Kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.hrms.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer>{

}
