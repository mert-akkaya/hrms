package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.ErrorDataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrue());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByApplicationDeadlineDesc() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrueOrderByApplicationDeadlineDesc());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndCompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrueAndEmployer_CompanyName(companyName));
	}

	@Override
	public Result changeStatus(int id) {
		var result =  this.jobAdvertisementDao.getById(id);
		result.setActive(false);
		this.jobAdvertisementDao.save(result);
		return new SuccessResult();
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		var result = this.jobAdvertisementDao.getById(id);
		if (result==null) {
			return new ErrorDataResult<JobAdvertisement>("Job Advertisement is not found");
		}
		return new SuccessDataResult<JobAdvertisement>(result,"Success");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		var date = LocalDate.now();
		jobAdvertisement.setCreateDate(date);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Success");
		
	}
	
	
}
