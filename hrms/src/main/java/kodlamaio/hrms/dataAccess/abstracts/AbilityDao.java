package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Ability;



public interface AbilityDao extends JpaRepository<Ability,Integer> {

	List<Ability> getAllByCurriculumVitaeId(int curriculumVitaeId);
}
