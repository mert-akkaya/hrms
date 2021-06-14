package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.entities.concretes.EmploymentType;

public interface EmploymentTypeService {

	DataResult<List<EmploymentType>> getAll();
}
