package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.dtos.CandidateForRegisterDto;
import kodlamaio.hrms.entities.dtos.EmployerForRegisterDto;

public interface AuthService {

	Result registerForCandidate(CandidateForRegisterDto candidateForRegisterDto);
	
	Result registerForEmployer(EmployerForRegisterDto employerForRegisterDto);
}
