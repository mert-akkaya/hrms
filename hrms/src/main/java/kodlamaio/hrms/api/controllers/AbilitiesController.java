package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AbilityService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
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
	public DataResult<List<Abilitiy>> getAll(){
		return this.abilityService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Abilitiy abilitiy){
		return this.abilityService.add(abilitiy);
	}
}
