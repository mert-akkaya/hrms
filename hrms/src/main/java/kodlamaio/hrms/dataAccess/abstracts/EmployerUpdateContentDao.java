package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.EmployerUpdateContent;

public interface EmployerUpdateContentDao extends JpaRepository<EmployerUpdateContent, Integer>  {

	EmployerUpdateContent findByEmployerId(int id);
}
