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
public class EmployerForRegisterDto {

	@NotNull
	@NotBlank
	private String companyName;
	
	@NotNull
	@NotBlank
    private String webAddress;
	
	@NotNull
	@NotBlank
    private String phoneNumber;
	
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
