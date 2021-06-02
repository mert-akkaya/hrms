package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeService {

	DataResult<List<CurriculumVitae>> getAll();
	Result add(CurriculumVitae curriculumVitae);
}
