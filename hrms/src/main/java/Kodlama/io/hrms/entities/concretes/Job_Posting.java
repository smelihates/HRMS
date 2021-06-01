package Kodlama.io.hrms.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_postings")
@AllArgsConstructor
@NoArgsConstructor
public class Job_Posting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@ManyToOne
	@JoinColumn(name="job_id")
	private Job job;
	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@Column(name="job_detail")
	private String jobDetail;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="deadline")
	private String deadline;
	
	@Column(name="open_position")
	private int openPosition;
	
	@Column(name="active")
	private boolean active=true;

	public Job_Posting(int id, Boolean active) {
		super();
		this.id = id;
		this.active = active;
	}


	

}
