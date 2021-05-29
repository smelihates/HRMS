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
@Table(name="email_verifications")
@AllArgsConstructor
@NoArgsConstructor
public class Email_Verification {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="verified")
	private Boolean verified;

	public Email_Verification(int id, Boolean verified) {
		super();
		this.id = id;
		this.verified = verified;
	}
	
	
	
}
