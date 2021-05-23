package kodlamaio.hrms.core.utilites.adapters.mernis;

import kodlamaio.hrms.core.utilites.adapters.VerificationService;
import kodlamaio.hrms.entities.dtos.UserForMernisValidateDto;

public class MernisVerificationAdapter implements VerificationService {

	@Override
	public boolean validate(UserForMernisValidateDto userForMernisValidate) {
		//simulation
		System.out.println("User verified");
		return false;
	}

}
