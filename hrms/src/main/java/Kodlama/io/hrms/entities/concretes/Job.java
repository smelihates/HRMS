package Kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="jobs")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","job_Postings"})
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int jobId;
	
	@Column(name="userid")
	private int userId;
	
	@Column(name="title")
	private String title;
	
	@OneToMany(mappedBy = "job")
	private List<Job_Posting> job_Postings;


	
		
}

