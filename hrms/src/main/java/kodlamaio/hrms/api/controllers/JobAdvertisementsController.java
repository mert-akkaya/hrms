package kodlamaio.hrms.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;


@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll(){
		var result = this.jobAdvertisementService.getAll();
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getByIsActiveTrue")
	public ResponseEntity<?> getByIsActiveTrue(){
		var result = this.jobAdvertisementService.getByIsActiveTrue();
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	@GetMapping("/getByIsActiveTrueOrderByApplicationDeadlineDesc")
	public ResponseEntity<?> getByIsActiveTrueOrderByApplicationDeadlineDesc(){
		
		var result = this.jobAdvertisementService.getByIsActiveTrueOrderByApplicationDeadlineDesc();
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	@GetMapping("/getByIsActiveTrueAndCompanyName")
	public ResponseEntity<?> getByIsActiveTrueAndCompanyName(@RequestParam String companyName){
		var result = this.jobAdvertisementService.getByIsActiveTrueAndCompanyName(companyName);
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	@GetMapping("/changeStatus")
	public ResponseEntity<?> changeStatus(@RequestParam int id) {
		var result = this.jobAdvertisementService.changeStatus(id);
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
}
