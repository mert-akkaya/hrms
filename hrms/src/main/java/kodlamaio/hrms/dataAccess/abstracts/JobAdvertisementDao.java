package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	List<JobAdvertisement> getByIsActiveTrue();
	
	List<JobAdvertisement> getByIsActiveTrue(Pageable pageable);
	
	List<JobAdvertisement> getByIsActiveTrueOrderByApplicationDeadlineDesc();
	
	List<JobAdvertisement> getByIsActiveTrueAndEmployer_CompanyName(String companyName);
	
	List<JobAdvertisement> getAllByIsActiveTrueAndCityIdAndEmploymentTypeId(int cityId,int employmentTypeId,Pageable pageable);

	List<JobAdvertisement> getAllByIsActiveTrueAndCityId(int cityId,Pageable pageable);
	
	List<JobAdvertisement> getAllByIsActiveTrueAndEmploymentTypeId(int employmentTypeId,Pageable pageable);
	JobAdvertisement getById(int id);
}
