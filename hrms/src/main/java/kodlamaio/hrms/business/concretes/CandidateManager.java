package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.ErrorResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;

@Service
public class CandidateManager implements CandidateService {

	private UserService userService;
	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,UserService userService) {
		this.candidateDao = candidateDao;
		this.userService = userService;
	}
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),Messages.candidateListed);
	}
	
	@Override
	public Result add(Candidate candidate) {
		
		  if (this.userService.getByMail(candidate.getEmail()).getData() !=null ||
		  this.checkIdentityNumber(candidate.getIdentityNumber()).getData() !=null) 
		  { 
			  return new ErrorResult("This email or identity number is already in use"); 
		  }
		 
		
		this.candidateDao.save(candidate);
		return new SuccessResult(Messages.candidateAdded);
	}
	
	
	private DataResult<Candidate> checkIdentityNumber(String identityNumber) {
		
		return new SuccessDataResult<Candidate>(this.candidateDao.getByIdentityNumber(identityNumber));
	}

	@Override
	public Result update(Candidate candidate) {
		this.candidateDao.save(candidate);
		return new SuccessResult("Success");
	}

	@Override
	public DataResult<Candidate> getById(int id) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getById(id));
	}

}
