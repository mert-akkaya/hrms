package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.Favorite;

public interface FavoriteService {

	DataResult<List<Favorite>> getAll();
	DataResult<List<Favorite>> getByCandidateId(int id);
	
	DataResult<Favorite> findByCandidateIdAndJobAdvertisementId(int candidateId,int jobAdvertismentId);
	
	Result add(Favorite favorite);
	Result remove(int favoriteId);
	
	
	
}
