package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.School;

public interface SchoolService {

	DataResult<List<School>> getAll();
	
	DataResult<List<School>> getAllSorted();
	
	Result add(School school);
}
