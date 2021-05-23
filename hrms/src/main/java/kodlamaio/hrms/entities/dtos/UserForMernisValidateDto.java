package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForMernisValidateDto {

	private String firstName;
	private String lastName;
	private int birthYear;
	private String identityNumber;
}
