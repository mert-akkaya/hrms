package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
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
	public ResponseEntity<?> registerForCandidate(@Valid @RequestBody CandidateForRegisterDto candidateForRegisterDto) {
		var result = this.authService.registerForCandidate(candidateForRegisterDto);
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	@PostMapping("/registerforemployer")
	public ResponseEntity<?> registerForEmployer(@Valid @RequestBody EmployerForRegisterDto employerForRegisterDto) {
		var result = this.authService.registerForEmployer(employerForRegisterDto);
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
}
