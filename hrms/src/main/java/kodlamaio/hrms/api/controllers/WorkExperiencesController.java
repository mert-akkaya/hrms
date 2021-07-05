package kodlamaio.hrms.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.entities.concretes.WorkExperience;

@RestController
@RequestMapping("api/workexperiences")
@CrossOrigin
public class WorkExperiencesController {

	private WorkExperienceService workExperienceService;
	
	@Autowired
	public WorkExperiencesController(WorkExperienceService workExperienceService) {
		this.workExperienceService = workExperienceService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		var result = this.workExperienceService.getAll();
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody WorkExperience workExperience) {
		var result = this.workExperienceService.add(workExperience);
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody WorkExperience workExperience) {
		var result = this.workExperienceService.update(workExperience);
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	
	@GetMapping("getAllOrderByDate")
	public ResponseEntity<?> getAllSorted(){
		var result = this.workExperienceService.getAllSorted();
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	
	@GetMapping("getAllByCurriculumVitaeIdAndOrderByFinishDate")
	public ResponseEntity<?> getAllByCurriculumVitaeIdOrderByFinishDateDesc(@RequestParam int curriculumVitaeId){
		var result = this.workExperienceService.getAllByCurriculumVitaeIdOrderByFinishDateDesc(curriculumVitaeId);
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam int workExperienceId) {
		var result = this.workExperienceService.delete(workExperienceId);
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
}
