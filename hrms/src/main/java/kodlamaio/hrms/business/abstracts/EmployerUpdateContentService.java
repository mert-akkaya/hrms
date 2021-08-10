package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerUpdateContent;

public interface EmployerUpdateContentService {

	DataResult<List<EmployerUpdateContent>> getAll();
	
	DataResult<EmployerUpdateContent> getByEmployerId(int id);
	
	DataResult<EmployerUpdateContent> getByStatusFalseEmployerId(int id);
	
	DataResult<List<EmployerUpdateContent>> getAllByStatusFalse();
	
	Result add(EmployerUpdateContent employerUpdateContent);
	
	Result confirmContent(int employerId);
	
	Result delete(int id);
}
