package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Favorite;

public interface FavoriteDao extends JpaRepository<Favorite,Integer> {

	List<Favorite> getByCandidateId(int id);
	
	Favorite findByCandidateIdAndJobAdvertisementId(int candidateId,int jobAdvertismentId);
}
