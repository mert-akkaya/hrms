package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilites.adapters.VerificationService;
import kodlamaio.hrms.core.utilites.email.MailService;
import kodlamaio.hrms.core.utilites.results.ErrorResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.CandidateForRegisterDto;
import kodlamaio.hrms.entities.dtos.EmployerForRegisterDto;
import kodlamaio.hrms.entities.dtos.UserForMernisValidateDto;

@Service
public class AuthManager implements AuthService {

	private CandidateService candidateService;
	private EmployerService employerService;
	private MailService mailService;
	private VerificationService verificationService;
	
	@Autowired
	public AuthManager(CandidateService candidateService,EmployerService employerService,MailService mailService,VerificationService verificationService) {
		this.candidateService = candidateService;
		this.employerService = employerService;
		this.mailService= mailService;
		this.verificationService = verificationService;
	}
	

	@Override
	public Result registerForCandidate(CandidateForRegisterDto candidateForRegisterDto) {
	 
			if (!this.confirmPassword(candidateForRegisterDto.getPassword(), candidateForRegisterDto.getPasswordConfirm()).isSuccess()) {
				return new ErrorResult("Password not match");
			}
			
		 	UserForMernisValidateDto userForMernisValidateDto = new UserForMernisValidateDto(candidateForRegisterDto.getFirstName(),candidateForRegisterDto.getLastName(),candidateForRegisterDto.getBirthYear(),candidateForRegisterDto.getIdentityNumber());
		 	
		 	if(!this.verificationService.validate(userForMernisValidateDto)) {
		 		return new ErrorResult("Mernis validate failed");
		 	}
		 
		    this.mailService.send(candidateForRegisterDto.getEmail(),"please verify");
		    
		 	Candidate candidate = new Candidate(candidateForRegisterDto.getEmail(),candidateForRegisterDto.getPassword(),candidateForRegisterDto.getFirstName(),candidateForRegisterDto.getLastName(),candidateForRegisterDto.getIdentityNumber(),candidateForRegisterDto.getBirthYear());
		 		
		 	var result = this.candidateService.add(candidate);
			return result;
		
	}
	
	
	@Override
	public Result registerForEmployer(EmployerForRegisterDto employerForRegisterDto) {
		if (!this.confirmPassword(employerForRegisterDto.getPassword(), employerForRegisterDto.getPasswordConfirm()).isSuccess()) {
			return new ErrorResult("Password not match");
		}
		if (this.checkEmailRegex(employerForRegisterDto)!=true) {
			return new ErrorResult("Please check email");
		}
		
		this.mailService.send(employerForRegisterDto.getEmail(), "please verify");
		Employer employer = new Employer(employerForRegisterDto.getEmail(),employerForRegisterDto.getPassword(),employerForRegisterDto.getCompanyName(),employerForRegisterDto.getWebAddress(),employerForRegisterDto.getPhoneNumber());
		
		var result = this.employerService.add(employer);
		return result;
		
	}

	private Result confirmPassword(String password,String confirmPassword) 
	{	
		
		if (password.equals(confirmPassword)) {
			
			return new SuccessResult("Password match");
		}
		return new ErrorResult("Password not match");
	
	}
	
	private boolean checkEmailRegex(EmployerForRegisterDto employerForRegisterDto) {
		var result = employerForRegisterDto.getEmail().split("@")[0];
		return result.equals(employerForRegisterDto.getWebAddress());
		 
	}

	


}
