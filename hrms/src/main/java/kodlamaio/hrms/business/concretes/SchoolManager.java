package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService {

	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		this.schoolDao = schoolDao;
	}
	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll());
	}

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("School added");
	}
	@Override
	public DataResult<List<School>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"graduateYear");
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(sort));
	}
	@Override
	public DataResult<List<School>> getAllByCurriculumVitae(int candidateId) {
		return new SuccessDataResult<List<School>>(this.schoolDao.getAllByCurriculumVitae_Candidate_Id(candidateId));
	}
	@Override
	public Result update(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("success");
	}
	@Override
	public Result delete(int schoolId) {
		this.schoolDao.deleteById(schoolId);;
		return new SuccessResult("success");
	}

}
