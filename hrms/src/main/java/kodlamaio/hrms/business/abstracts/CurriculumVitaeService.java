package kodlamaio.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.dtos.CurriculumVitaeDto;

public interface CurriculumVitaeService {

	DataResult<List<CurriculumVitae>> getAll();
	DataResult<List<CurriculumVitae>> getByCandidateId(int id);
	DataResult<CurriculumVitaeDto> getByDto(int curriculumVitaeId);
	DataResult<CurriculumVitae> getById(int id);
	Result uploadPhoto(int curriculumVitaeId,MultipartFile multipartFile) throws IOException;
	Result add(CurriculumVitae curriculumVitae);
	Result update(CurriculumVitae curriculumVitae);
}
