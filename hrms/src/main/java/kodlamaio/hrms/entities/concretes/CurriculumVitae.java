package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="curriculum_vitaes")
public class CurriculumVitae {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	@Column(name="photo_url")
	private String photoUrl;
	
	@Column(name="linkedin_address")
	private String linkedinAddress;
	
	@Column(name="github_address")
	private String githubAddress;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	
	@OneToMany(mappedBy = "curriculumVitae",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<School> schools;
	
	
	@OneToMany(mappedBy = "curriculumVitae")
	@JsonIgnore
	private List<WorkExperience> workExperiences;
	
	
	@OneToMany(mappedBy = "curriculumVitae")
	@JsonIgnore
	private List<Abilitiy> abilities;
	
	
	@OneToMany(mappedBy = "curriculumVitae")
	@JsonIgnore
	private List<ForeignLanguage> foreignLanguages;
}
