package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.EmployerUpdateContentService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.ErrorResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerUpdateContentDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.EmployerUpdateContent;

@Service
public class EmployerUpdateContentManager implements EmployerUpdateContentService {

	private EmployerUpdateContentDao employerUpdateContentDao ;
	private EmployerService employerService;
	
	@Autowired
	public EmployerUpdateContentManager(EmployerUpdateContentDao employerUpdateContentDao,EmployerService employerService) {
		this.employerUpdateContentDao = employerUpdateContentDao;
		this.employerService = employerService;
	}
	@Override
	public DataResult<List<EmployerUpdateContent>> getAll() {
		return new SuccessDataResult<List<EmployerUpdateContent>>(this.employerUpdateContentDao.findAll());
	}

	@Override
	public DataResult<EmployerUpdateContent> getByEmployerId(int id) {
		return new SuccessDataResult<EmployerUpdateContent>(this.employerUpdateContentDao.getByEmployerId(id));
	}

	@Override
	public Result add(EmployerUpdateContent employerUpdateContent) {
		employerUpdateContent.setStatus(false);
		this.employerUpdateContentDao.save(employerUpdateContent);
		return new SuccessResult();
	}
	@Override
	public Result confirmContent(int employerId) {
		Employer employer = this.employerService.getById(employerId).getData();
		EmployerUpdateContent content = this.employerUpdateContentDao.getByStatusFalseAndEmployerId(employerId);
		
		if(content!=null) {
			var result = checkAndSetUpdate(employer, content);
			if (!result.isSuccess()) {
				return new ErrorResult(result.getMessage());
			}
			return new SuccessResult();
		}
		return new ErrorResult("update request not found");
	}
	
	private Result checkAndSetUpdate(Employer employer , EmployerUpdateContent content) {
		if (content.getContent().getCompanyName()!=null) {
			employer.setCompanyName(content.getContent().getCompanyName());
		}
		if (content.getContent().getEmail()!=null) {
			employer.setEmail(content.getContent().getEmail());
		}
		if (content.getContent().getPassword()!=null) {
			employer.setPassword(content.getContent().getPassword());
		}
		if (content.getContent().getPhoneNumber()!=null) {
			employer.setPhoneNumber(content.getContent().getPhoneNumber());
		}
		if (content.getContent().getWebAddress()!=null) {
			employer.setWebAddress(content.getContent().getWebAddress());
		}
		content.setStatus(true);
		this.employerService.update(employer);
		return new SuccessResult();
		
		
	}
	@Override
	public DataResult<EmployerUpdateContent> getByStatusFalseEmployerId(int id) {
		return new SuccessDataResult<EmployerUpdateContent>(this.employerUpdateContentDao.getByStatusFalseAndEmployerId(id));
	}
	@Override
	public DataResult<List<EmployerUpdateContent>> getAllByStatusFalse() {
		return new SuccessDataResult<List<EmployerUpdateContent>>(this.employerUpdateContentDao.getAllByStatusFalse());
	}
	
	

}
