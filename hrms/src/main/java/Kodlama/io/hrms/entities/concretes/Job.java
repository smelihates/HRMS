package Kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jobs")
public class Job {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="userid")
	private int userid;
	
	@Column(name="title")
	private String title;

	public Job() {
		super();
	}

	public Job(int id, int userid, String title) {
		super();
		this.id = id;
		this.userid = userid;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
		
}

