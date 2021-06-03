package kodlamaio.hrms.business.concretes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.core.utilites.image.ImageService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

	private CurriculumVitaeDao curriculumVitaeDao;
	private ImageService imageService;
	
	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao,ImageService imageService) {
		this.curriculumVitaeDao= curriculumVitaeDao;
		this.imageService = imageService;
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
	public DataResult<List<CurriculumVitae>> getByCandidateId(int id) {
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.getByCandidate_Id(id));
	}
}
