package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService  {

	DataResult<List<Employer>> getAll();
	DataResult<Employer> getById(int id);
	Result add(Employer employer);
	Result update(Employer employer);
}
