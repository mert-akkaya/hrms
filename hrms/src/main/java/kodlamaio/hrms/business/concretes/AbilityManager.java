package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AbilityService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.AbilityDao;
import kodlamaio.hrms.entities.concretes.Ability;

@Service
public class AbilityManager implements AbilityService {

	private AbilityDao abilityDao;
	
	@Autowired
	public AbilityManager(AbilityDao abilityDao) {
		this.abilityDao = abilityDao;
	}
	@Override
	public DataResult<List<Ability>> getAll() {
		return new SuccessDataResult<List<Ability>>(this.abilityDao.findAll());
	}

	@Override
	public Result add(Ability abilitiy) {
		this.abilityDao.save(abilitiy);
		return new SuccessResult("Ability added");
	}
	@Override
	public Result update(Ability abilitiy) {
		this.abilityDao.save(abilitiy);
		return new SuccessResult("Ability added");
	}
	@Override
	public DataResult<List<Ability>> getAllByCurriculumVitaeId(int curriculumVitaeId) {
		return new SuccessDataResult<List<Ability>>(this.abilityDao.getAllByCurriculumVitaeId(curriculumVitaeId));
	}
	@Override
	public Result delete(int abilityId) {
		this.abilityDao.deleteById(abilityId);
		return new SuccessResult();
	}

}
