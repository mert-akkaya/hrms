package kodlamaio.hrms.entities.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateForRegisterDto {

		@NotNull
		@NotBlank
	    private String firstName;
		@NotNull
		@NotBlank
	    private String lastName;
		@NotNull
		@NotBlank
	    private String identityNumber;
		@NotNull
	    private int birthYear;
	    @Email
	    @NotNull
		@NotBlank
	    private String email;
	    @NotNull
		@NotBlank
	    private String password;
	    @NotNull
		@NotBlank
	    private String passwordConfirm;
}
