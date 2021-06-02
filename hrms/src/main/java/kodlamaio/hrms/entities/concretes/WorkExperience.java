package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="work_experiences")
public class WorkExperience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "curriculum_vitae_id")
	private CurriculumVitae curriculumVitae;
	
	@Column(name="workplace_name")
	private String workplaceName;
	
	@Column(name="position")
	private String position;
	
	@Column(name="start_date")
	private LocalDate startDate;
	
	@Column(name="finis_date")
	private LocalDate finishDate;
}
