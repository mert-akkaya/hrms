package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.WorkExperience;

public interface WorkExperienceService  {

	 DataResult<List<WorkExperience>> getAll();
	 
	 DataResult<List<WorkExperience>> getAllSorted();
	 
	 DataResult<List<WorkExperience>> getAllByCurriculumVitaeIdOrderByFinishDateDesc(int curriculumVitaeId);

	 Result add(WorkExperience workExperience);
	 Result update(WorkExperience workExperience);
}
