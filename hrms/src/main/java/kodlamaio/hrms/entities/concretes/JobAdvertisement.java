package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_advertisements")
@Entity
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	//@Column(name="employer_id")
	//private int employerId;
	
	//@Column(name="job_title_id")
	//private int jobTitleId;
	
	//@Column(name="city_id")
	//private int cityId;
	
	@Column(name="description")
	private String description;
	
	@Column(name="count_of_open_positions")
	private int countOfOpenPosition;
	
	@Column(name="application_deadline")
	private LocalDate applicationDeadline;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="create_date")
	private LocalDate createDate;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne 
	@JoinColumn(name="job_title_id")
	private JobTitle jobTitle;
	
	@ManyToOne
	@JoinColumn(name="employment_type_id")
	private EmploymentType employmentType;
	
	@ManyToOne
	@JoinColumn(name="work_type_id")
	private WorkType workType;
	
	@OneToMany(mappedBy = "candidate")
	@JsonIgnore
	private List<Favorite> favorites;
	
	
}
