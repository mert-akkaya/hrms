package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.School;

@RestController
@RequestMapping("api/schools")
public class SchoolsController {

	private SchoolService schoolService;
	
	@Autowired
	public SchoolsController(SchoolService schoolService) {
		this.schoolService = schoolService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<School>> getAll(){
		return this.schoolService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody School school) {
		return this.schoolService.add(school);
	}
}
