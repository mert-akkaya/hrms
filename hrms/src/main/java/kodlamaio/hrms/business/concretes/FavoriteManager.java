package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.FavoriteService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.FavoriteDao;
import kodlamaio.hrms.entities.concretes.Favorite;

@Service
public class FavoriteManager implements FavoriteService {

	private FavoriteDao favoriteDao;
	
	@Autowired
	public FavoriteManager(FavoriteDao favoriteDao) {
		this.favoriteDao = favoriteDao;
	}
	
	@Override
	public DataResult<List<Favorite>> getAll() {
		return new SuccessDataResult<List<Favorite>>(this.favoriteDao.findAll());
	}

	@Override
	public DataResult<List<Favorite>> getByCandidateId(int id) {
		return new SuccessDataResult<List<Favorite>>(this.favoriteDao.getByCandidateId(id));
	}

	@Override
	public Result add(Favorite favorite) {
		this.favoriteDao.save(favorite);
		return new SuccessResult();
	}

	@Override
	public Result remove(Favorite favorite) {
		this.favoriteDao.delete(favorite);
		return new SuccessResult();
	}

	@Override
	public DataResult<Favorite> findByCandidateIdAndJobAdvertisementId(int candidateId, int jobAdvertismentId) {
		return new SuccessDataResult<Favorite>(this.favoriteDao.findByCandidateIdAndJobAdvertisementId(candidateId, jobAdvertismentId));
	}

}
