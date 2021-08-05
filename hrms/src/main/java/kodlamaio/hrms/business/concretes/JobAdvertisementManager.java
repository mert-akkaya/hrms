package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.ErrorDataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertismentFilterDto;

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
		result.setActive(true);
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

	@Override
	public Result delete(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.delete(jobAdvertisement);
		return new SuccessResult("Success");
	}

	
	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue(int pageNo,int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrue(pageable));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActiveTrueAndFilter(JobAdvertismentFilterDto advertismentFilterDto, int pageNo, int pageSize) {
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
	     return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllByFilter(advertismentFilterDto, pageable).getContent(),this.jobAdvertisementDao.getAllByFilter(advertismentFilterDto, pageable).getTotalElements()+"");
	}

	
	
	
}
