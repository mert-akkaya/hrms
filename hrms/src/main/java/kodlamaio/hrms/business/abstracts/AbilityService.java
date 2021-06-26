package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.Ability;

public interface AbilityService {

	DataResult<List<Ability>> getAll();
	
	DataResult<List<Ability>> getAllByCurriculumVitaeId(int curriculumVitaeId);
	
	Result add(Ability abilitiy);
	Result update(Ability abilitiy);
	
	
}
