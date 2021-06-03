package kodlamaio.hrms.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AbilityService;
import kodlamaio.hrms.entities.concretes.Abilitiy;

@RestController
@RequestMapping("api/abilities")
public class AbilitiesController {

	private AbilityService abilityService;
	
	@Autowired
	public AbilitiesController(AbilityService abilityService) {
		this.abilityService = abilityService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		var result = this.abilityService.getAll();
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Abilitiy abilitiy){
		var result = this.abilityService.add(abilitiy);
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
}
