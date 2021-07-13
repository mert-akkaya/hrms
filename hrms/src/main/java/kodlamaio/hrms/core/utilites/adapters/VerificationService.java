package kodlamaio.hrms.core.utilites.adapters;


import kodlamaio.hrms.entities.dtos.UserForMernisValidateDto;

public interface VerificationService {

	boolean checkIfRealPerson(UserForMernisValidateDto userForMernisValidate);
}
