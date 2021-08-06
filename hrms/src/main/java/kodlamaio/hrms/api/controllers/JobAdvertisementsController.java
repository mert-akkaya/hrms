package kodlamaio.hrms.api.controllers;


import java.io.Console;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertismentFilterDto;



@RestController
@RequestMapping("/api/jobadvertisements")
@CrossOrigin
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
	
	@GetMapping("/getByİsActiveTruePageable")
	public ResponseEntity<?> getByIsActiveTrue(@RequestParam int pageNo,int pageSize){
		var result = this.jobAdvertisementService.getByIsActiveTrue(pageNo, pageSize);
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
	
	
	@GetMapping("/getById")
	public ResponseEntity<?> getById(@RequestParam int id){
		var result = this.jobAdvertisementService.getById(id);
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	
	
	@PostMapping("/getAllByIsActiveTrueAndFilter") 
	public ResponseEntity<?> getAllByIsActiveTrueAndFilter(@RequestParam int pageNo,int pageSize, @RequestBody JobAdvertismentFilterDto jobAdvertismentFilterDto){
		var result = this.jobAdvertisementService.getAllByIsActiveTrueAndFilter(jobAdvertismentFilterDto, pageNo, pageSize);
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody JobAdvertisement jobAdvertisement){
		var result = this.jobAdvertisementService.add(jobAdvertisement);
		if(!result.isSuccess()) {
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody JobAdvertisement jobAdvertisement){
		var result = this.jobAdvertisementService.delete(jobAdvertisement);
		if(!result.isSuccess()) {
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}
	
	
}
