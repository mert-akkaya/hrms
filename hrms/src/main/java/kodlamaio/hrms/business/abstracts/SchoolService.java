package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.School;

public interface SchoolService {

	DataResult<List<School>> getAll();
	
	DataResult<List<School>> getAllSorted();
	
	DataResult<List<School>> getAllByCurriculumVitae(int candidateId);
	
	Result add(School school);
	Result update (School school);
	Result delete (int schoolId);
}
