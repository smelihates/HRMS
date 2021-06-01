package Kodlama.io.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingDto {
	private int id;
	private String companyName;
	private String title;
	private int openPosition;
	private String dateOfPublish;
	private String deadline;
}
