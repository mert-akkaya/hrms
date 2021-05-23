package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.dtos.CandidateForRegisterDto;
import kodlamaio.hrms.entities.dtos.EmployerForRegisterDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private AuthService authService;
	
	@Autowired
	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	@PostMapping("/registerforcandidate")
	public Result registerForCandidate(@RequestBody CandidateForRegisterDto candidateForRegisterDto) {
		return this.authService.registerForCandidate(candidateForRegisterDto);
	}
	@PostMapping("/registerforemployer")
	public Result registerForEmployer(@RequestBody EmployerForRegisterDto employerForRegisterDto) {
		return this.authService.registerForEmployer(employerForRegisterDto);
	}
}
