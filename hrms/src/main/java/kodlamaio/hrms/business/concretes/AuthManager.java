package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
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

	private UserService userService;
	private CandidateService candidateService;
	private EmployerService employerService;
	private MailService mailService;
	private VerificationService verificationService;
	
	@Autowired
	public AuthManager(UserService userService,CandidateService candidateService,EmployerService employerService,MailService mailService,VerificationService verificationService) {
		this.userService = userService;
		this.candidateService = candidateService;
		this.employerService = employerService;
		this.mailService= mailService;
		this.verificationService = verificationService;
	}
	

	@Override
	public Result registerForCandidate(CandidateForRegisterDto candidateForRegisterDto) {
		// her alanın eksiksiz girilmesi frontend de kontrol edilecek

		 if (!this.checkEmail(candidateForRegisterDto.getEmail()).isSuccess() || 
			 !this.checkIdentityNumber(candidateForRegisterDto.getIdentityNumber()).isSuccess())
		 {
		    return new ErrorResult("This email or identity number is already in use");   
		 }  
		 
		 //aşağıdaki kısım model mapper ile kolayca yapılabilir
		 
		 	UserForMernisValidateDto userForMernisValidateDto = new UserForMernisValidateDto();
		 	userForMernisValidateDto.setFirstName(candidateForRegisterDto.getFirstName());
		 	userForMernisValidateDto.setLastName(candidateForRegisterDto.getLastName());
		 	userForMernisValidateDto.setBirthYear(candidateForRegisterDto.getBirthYear());
		 	userForMernisValidateDto.setIdentityNumber(candidateForRegisterDto.getIdentityNumber());
		 	
		 	if(!this.verificationService.validate(userForMernisValidateDto)) {
		 		return new ErrorResult("Mernis validate failed");
		 	}
		 
		    this.mailService.send(candidateForRegisterDto.getEmail(),"please verify");
		    
		 	Candidate candidate = new Candidate();  
		 	candidate.setFirstName(candidateForRegisterDto.getFirstName());
		 	candidate.setLastName(candidateForRegisterDto.getLastName());
		 	candidate.setEmail(candidateForRegisterDto.getEmail());
		 	candidate.setBirthYear(candidateForRegisterDto.getBirthYear());
		 	candidate.setIdentityNumber(candidateForRegisterDto.getIdentityNumber());
		 	candidate.setPassword(candidateForRegisterDto.getPassword());
		 	
		 	this.candidateService.add(candidate);
			return new SuccessResult("Register success");
		  
	}
	
	
	@Override
	public Result registerForEmployer(EmployerForRegisterDto employerForRegisterDto) {
		
		if (!this.checkEmail(employerForRegisterDto.getEmail()).isSuccess()) {
			return new ErrorResult("This email is already exist");
		}
		if (this.checkEmailRegex(employerForRegisterDto)!=true) {
			return new ErrorResult("Please check email");
		}
		
		this.mailService.send(employerForRegisterDto.getEmail(), "please verify");
		Employer employer = new Employer();
		employer.setCompanyName(employerForRegisterDto.getCompanyName());
		employer.setEmail(employerForRegisterDto.getEmail());
		employer.setPassword(employerForRegisterDto.getPassword());
		employer.setPhoneNumber(employerForRegisterDto.getPhoneNumber());
		employer.setWebAddress(employerForRegisterDto.getWebAddress());
		
		this.employerService.add(employer);
		return new SuccessResult("Register success");
		
	}

	
	
	private Result checkEmail(String email) {
		var result = this.userService.getByMail(email);
		if (result.getData()!=null) {
			return new ErrorResult("Email already exists");
		}
		return new SuccessResult();
	}
	
	private Result checkIdentityNumber(String identityNumber) {
		var result = this.candidateService.getByIdentityNumber(identityNumber);
		if (result.getData()!=null) {
			return new ErrorResult("Identity numbeer already exist");
		}
		return new SuccessResult();
	}

	private boolean checkEmailRegex(EmployerForRegisterDto employerForRegisterDto) {
		var result = employerForRegisterDto.getEmail().split("@")[0];
		return result.equals(employerForRegisterDto.getWebAddress());
		 
	}

	


}
