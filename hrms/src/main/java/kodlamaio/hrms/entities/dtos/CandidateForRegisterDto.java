package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateForRegisterDto {

	    private String firstName;
	    private String lastName;
	    private String identityNumber;
	    private int birthYear;
	    private String email;
	    private String password;
	    private String passwordConfirm;
}
