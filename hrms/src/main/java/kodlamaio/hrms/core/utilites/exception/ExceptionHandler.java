package kodlamaio.hrms.core.utilites.exception;


import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
	public ResponseEntity<CustomErrorRespone> exceptionHandler(Exception e){
		CustomErrorRespone error = new CustomErrorRespone();
		error.setErrorCode(e.getClass());
		error.setErrorMessage(e.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTime(LocalDate.now());
		return new ResponseEntity<CustomErrorRespone>(error,HttpStatus.BAD_REQUEST); 
	}
}
