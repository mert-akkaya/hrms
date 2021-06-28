package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Pageable;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getByIsActiveTrue();
	DataResult<List<JobAdvertisement>> getByIsActiveTrue(int pageNo,int pageSize);
	DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByApplicationDeadlineDesc();
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndCompanyName(String companyName);
	DataResult<List<JobAdvertisement>> getAllByCityIdAndEmploymentTypeId(int cityId,int employmentTypeId);
	DataResult<List<JobAdvertisement>> getAllByIsActiveTrueAndCityId(int cityId);
	DataResult<List<JobAdvertisement>> getAllByIsActiveTrueAndEmploymentTypeId(int employmentTypeId);
	DataResult<JobAdvertisement> getById(int id);
	Result add(JobAdvertisement jobAdvertisement);
	Result delete(JobAdvertisement jobAdvertisement);
	
	Result changeStatus(int id);
}
