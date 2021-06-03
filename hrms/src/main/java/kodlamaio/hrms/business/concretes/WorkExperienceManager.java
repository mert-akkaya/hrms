package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkExperienceDao;
import kodlamaio.hrms.entities.concretes.WorkExperience;

@Service
public class WorkExperienceManager implements WorkExperienceService {

	private WorkExperienceDao  workExperienceDao;
	@Autowired
	public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
		this.workExperienceDao = workExperienceDao;
	}
	
	@Override
	public DataResult<List<WorkExperience>> getAll() {
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findAll());
	}

	@Override
	public Result add(WorkExperience workExperience) {
		this.workExperienceDao.save(workExperience);
		return new SuccessResult("Work experience added");
	}

	@Override
	public DataResult<List<WorkExperience>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"graduateYear");
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findAll(sort));
	}

}
