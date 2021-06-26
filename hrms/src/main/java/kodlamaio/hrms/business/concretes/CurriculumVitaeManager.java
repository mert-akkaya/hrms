package kodlamaio.hrms.business.concretes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.AbilityService;
import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.business.abstracts.ForeignLanguageService;
import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilites.image.ImageService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.dtos.CurriculumVitaeDto;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

	private CurriculumVitaeDao curriculumVitaeDao;
	private ImageService imageService;
	private SchoolService schoolService;
	private AbilityService abilityService;
	private ForeignLanguageService foreignLanguageService;
	private WorkExperienceService workExperienceService;
	
	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao,ImageService imageService,SchoolService schoolService,AbilityService abilityService,ForeignLanguageService foreignLanguageService,WorkExperienceService workExperienceService) {
		this.curriculumVitaeDao= curriculumVitaeDao;
		this.imageService = imageService;
		this.schoolService = schoolService;
		this.abilityService= abilityService;
		this.foreignLanguageService = foreignLanguageService;
		this.workExperienceService = workExperienceService;
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAll());
	}

	@Override
	public Result add(CurriculumVitae curriculumVitae) {
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult();
	}

	@Override
	public Result uploadPhoto(int currucilumVitaeId,MultipartFile multipartFile) throws IOException {
		CurriculumVitae curriculumVitae = this.curriculumVitaeDao.getById(currucilumVitaeId);
		var result = this.imageService.upload(multipartFile);
		var imageUrl = result.getData().get("url");
		var urlToString = imageUrl.toString();
		curriculumVitae.setPhotoUrl(urlToString);
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult("added");
		
	}

	@Override
	public DataResult<CurriculumVitae> getByCandidateId(int id) {
		return new SuccessDataResult<CurriculumVitae>(this.curriculumVitaeDao.getByCandidate_Id(id));
	}

	@Override
	public Result update(CurriculumVitae curriculumVitae) {
		
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult("Success");
		
	}

	@Override
	public DataResult<CurriculumVitaeDto> getByDto(int curriculumVitaeId) {
		CurriculumVitaeDto curriculumVitaeDto = new CurriculumVitaeDto();
		curriculumVitaeDto.setAbilities(this.abilityService.getAllByCurriculumVitaeId(curriculumVitaeId).getData());
		curriculumVitaeDto.setForeignLanguages(this.foreignLanguageService.getAllByCurriculumVitaeId(curriculumVitaeId).getData());
		curriculumVitaeDto.setSchools(this.schoolService.getAllByCurriculumVitae(curriculumVitaeId).getData());
		curriculumVitaeDto.setWorkExperiences(this.workExperienceService.getAllByCurriculumVitaeIdOrderByFinishDateDesc(curriculumVitaeId).getData());
		
		return new SuccessDataResult<CurriculumVitaeDto>(curriculumVitaeDto);
	}
}
