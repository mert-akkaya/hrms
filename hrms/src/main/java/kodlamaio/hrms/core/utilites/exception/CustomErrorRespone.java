package kodlamaio.hrms.core.utilites.exception;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomErrorRespone {

	private Object errorCode;
	private String errorMessage;
	private int status;
	private LocalDate time;
	
	
}
