package kodlamaio.hrms.core.utilites.adapters.mernis;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilites.adapters.VerificationService;
import kodlamaio.hrms.entities.dtos.UserForMernisValidateDto;

@Service
public class MernisVerificationAdapter implements VerificationService {

	@Override
	public boolean validate(UserForMernisValidateDto userForMernisValidate) {
		//simulation
		System.out.println("User verified");
		return true;
	}

}
