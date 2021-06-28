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

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeesController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll(){
		var result = this.employeeService.getAll();
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getById")
	public ResponseEntity<?> getById(@RequestParam int id){
		var result = this.employeeService.getById(id);
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Employee employee){
		var result = this.employeeService.add(employee);
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Employee employee){
		var result = this.employeeService.update(employee);
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
}
