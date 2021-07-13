package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertismentFilterDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	List<JobAdvertisement> getByIsActiveTrue();
	
	List<JobAdvertisement> getByIsActiveTrue(Pageable pageable);
	
	List<JobAdvertisement> getByIsActiveTrueOrderByApplicationDeadlineDesc();
	
	List<JobAdvertisement> getByIsActiveTrueAndEmployer_CompanyName(String companyName);
	
	
	@Query("Select j from kodlamaio.hrms.entities.concretes.JobAdvertisement j where ((:#{#filter.cityId}) IS NULL OR j.city.id IN (:#{#filter.cityId}))"
	        +" and ((:#{#filter.employmentTypeId}) IS NULL OR j.employmentType.id IN (:#{#filter.employmentTypeId}))"
	        +" and j.isActive=true")
	Page<JobAdvertisement> getAllByFilter(@Param("filter") JobAdvertismentFilterDto jobAdvertismentFilterDto,Pageable pageable);
	
	JobAdvertisement getById(int id);
}
