package kodlamaio.hrms.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ForeignLanguageService;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;

@RestController
@RequestMapping("api/foreignlanguages")
public class ForeignLanguagesController {

	private ForeignLanguageService foreignLanguageService;
	
	@Autowired
	public ForeignLanguagesController(ForeignLanguageService foreignLanguageService) {
		this.foreignLanguageService = foreignLanguageService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		var result = this.foreignLanguageService.getAll();
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody ForeignLanguage foreignLanguage) {
		var result = this.foreignLanguageService.add(foreignLanguage);
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
}
