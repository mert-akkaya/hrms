package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmploymentTypeService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.EmploymentTypeDao;
import kodlamaio.hrms.entities.concretes.EmploymentType;

@Service
public class EmploymentTypeManager implements EmploymentTypeService {

	private EmploymentTypeDao employmentTypeDao;
	
	@Autowired
	public EmploymentTypeManager(EmploymentTypeDao employmentTypeDao) {
		this.employmentTypeDao = employmentTypeDao;
	}

	@Override
	public DataResult<List<EmploymentType>> getAll() {
		return new SuccessDataResult<List<EmploymentType>>(this.employmentTypeDao.findAll());
	}
	
	
}
