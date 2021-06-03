package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;

public interface ForeignLanguageService {

	DataResult<List<ForeignLanguage>> getAll();
	Result add(ForeignLanguage foreignLanguage);
}
