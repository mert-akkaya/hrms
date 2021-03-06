package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.ErrorDataResult;
import kodlamaio.hrms.core.utilites.results.ErrorResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;


@Service
public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		this.jobTitleDao = jobTitleDao;
	}
	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(),Messages.jobTitleListed);
	}
	@Override
	public Result add(JobTitle jobTitle) {
		if (this.checkJobTitle(jobTitle.getTitle()).getData() !=null) {
			return new ErrorResult("Job title already exist");
		}
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult(Messages.jobTitleAdded);
	}
	 
	private DataResult<JobTitle> checkJobTitle(String title) {
		return new ErrorDataResult<JobTitle>(this.jobTitleDao.getByTitle(title));
	}

}
