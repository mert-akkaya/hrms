package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.Abilitiy;

public interface AbilityService {

	DataResult<List<Abilitiy>> getAll();
	Result add(Abilitiy abilitiy);
}
