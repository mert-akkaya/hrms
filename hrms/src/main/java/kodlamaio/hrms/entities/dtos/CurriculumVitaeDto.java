package kodlamaio.hrms.entities.dtos;


import java.util.List;

import kodlamaio.hrms.entities.concretes.Ability;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.concretes.WorkExperience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumVitaeDto {

	private List<School> schools;
	private List<Ability> abilities;
	private List<ForeignLanguage> foreignLanguages;
	private List<WorkExperience> workExperiences;
	
}
