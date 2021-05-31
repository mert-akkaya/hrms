package kodlamaio.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="candidates")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate extends User {

	@Column(name="first_name")
	@NotNull
	@NotBlank
	private String firstName;
	
	@Column(name="last_name")
	@NotNull
	@NotBlank
	private String lastName;
	
	@Column(name="identity_number")
	@NotNull
	@NotBlank
	private String identityNumber;
	
	@Column(name="birth_year")
	@NotNull
	@NotBlank
	private int birthYear;
	
	
	 public Candidate(String email,String password,String firstName, String lastName, String identityNumber, int  birthYear) {
	        super(email,password);
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.identityNumber = identityNumber;
	        this.birthYear = birthYear;
	    }
}
