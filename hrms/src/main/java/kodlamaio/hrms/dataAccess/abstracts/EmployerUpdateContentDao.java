package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.EmployerUpdateContent;

public interface EmployerUpdateContentDao extends JpaRepository<EmployerUpdateContent, Integer>  {

	EmployerUpdateContent getByStatusFalseAndEmployerId(int id);
	
	List<EmployerUpdateContent> getAllByStatusFalse();
	
	EmployerUpdateContent getByEmployerId(int id);
}
