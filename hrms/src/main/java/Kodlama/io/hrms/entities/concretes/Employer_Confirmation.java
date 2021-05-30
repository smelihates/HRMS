package Kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="employer_confirmations")
@AllArgsConstructor
@NoArgsConstructor
public class Employer_Confirmation {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="confirmated")
	private Boolean confirmated;
	
	@Column(name="confirmated_by_staff_id")
	private int confirmatedByStaffId;

	public Employer_Confirmation(int id, Boolean confirmated) {
		super();
		this.id = id;
		this.confirmated = confirmated;
	}
	
	

}
