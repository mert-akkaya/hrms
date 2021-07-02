package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerUpdateContent;

public interface EmployerUpdateContentService {

	DataResult<List<EmployerUpdateContent>> getAll();
	
	DataResult<EmployerUpdateContent> findByEmployerId(int id);
	
	Result add(EmployerUpdateContent employerUpdateContent);
	
	Result confirmContent(int employerId);
}
