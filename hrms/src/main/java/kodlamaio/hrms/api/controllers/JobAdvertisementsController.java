package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getByIsActiveTrue")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue(){
		return this.jobAdvertisementService.getByIsActiveTrue();
	}
	@GetMapping("/getByIsActiveTrueOrderByApplicationDeadlineDesc")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByApplicationDeadlineDesc(){
		
		return this.jobAdvertisementService.getByIsActiveTrueOrderByApplicationDeadlineDesc();
	}
	@GetMapping("/getByIsActiveTrueAndCompanyName")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndCompanyName(@RequestParam String companyName){
		return this.jobAdvertisementService.getByIsActiveTrueAndCompanyName(companyName);
	}
	@GetMapping("/changeStatus")
	public Result changeStatus(@RequestParam int id) {
		return this.jobAdvertisementService.changeStatus(id);
	}
}
