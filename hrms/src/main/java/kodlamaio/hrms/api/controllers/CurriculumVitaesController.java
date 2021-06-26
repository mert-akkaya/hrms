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
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;

@RestController
@RequestMapping("api/curriculumvitaes")
@CrossOrigin
public class CurriculumVitaesController {

	private CurriculumVitaeService curriculumVitaeService;
	
	@Autowired
	public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
		this.curriculumVitaeService = curriculumVitaeService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		var result = this.curriculumVitaeService.getAll();
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getByDto")
	public ResponseEntity<?> getByDto(@RequestParam int curriculumVitaeId){
		var result = this.curriculumVitaeService.getByDto(curriculumVitaeId);
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody CurriculumVitae curriculumVitae) {
		var result = this.curriculumVitaeService.add(curriculumVitae);
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	
	@PostMapping("/uploadimage")
	public ResponseEntity<?> uploadImage(@RequestParam int curriculmVitaeId , @RequestParam MultipartFile multipartFile){
		Result result = null;
		try {
			   result = this.curriculumVitaeService.uploadPhoto(curriculmVitaeId, multipartFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return  ResponseEntity.ok(result);
		
	}
	@GetMapping("/getbycandidateid")
    public ResponseEntity<?> getByCandidateId(int id){
        var result = this.curriculumVitaeService.getByCandidateId(id);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody CurriculumVitae curriculumVitae){
        var result = this.curriculumVitaeService.update(curriculumVitae);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
