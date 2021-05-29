package Kodlama.io.hrms.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name="employees")
@PrimaryKeyJoinColumn(name="id",referencedColumnName = "id")
@AllArgsConstructor
@NoArgsConstructor

public class Employee extends User {
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="sur_name")
	private String surName;
	
	@Column(name="tc_no")
	private String tcNo;
	
	@Column(name="birth_date")
	private String birthDate;
	

}

