package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerUpdateContentService;
import kodlamaio.hrms.entities.concretes.EmployerUpdateContent;

@RestController
@RequestMapping("api/employerUpdateContents")
public class EmployerUpdateContentsController {

	private EmployerUpdateContentService employerUpdateContentService;
	
	@Autowired
	public EmployerUpdateContentsController(EmployerUpdateContentService employerUpdateContentService) {
		this.employerUpdateContentService= employerUpdateContentService;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll(){
		var result = this.employerUpdateContentService.getAll();
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getById")
	public ResponseEntity<?> getByEmployerId(@RequestParam int id){
		var result = this.employerUpdateContentService.findByEmployerId(id);
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody EmployerUpdateContent employerUpdateContent){
		var result = this.employerUpdateContentService.add(employerUpdateContent);
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	
	@PostMapping("/confirmContent")
	public ResponseEntity<?> confirmContent(@RequestParam int employerId){
		var result = this.employerUpdateContentService.confirmContent(employerId);
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
}
