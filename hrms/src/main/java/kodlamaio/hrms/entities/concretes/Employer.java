package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name="employers")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class Employer extends User {

	@Column(name="company_name")
	private String companyName;
	@Column(name="web_address")
	private String webAddress;
	@Column(name="phone_number")
	private String phoneNumber;
	
	
	@OneToMany(mappedBy = "employer")
	@JsonIgnore
	private List<JobAdvertisement> jobAdvertisements;
	
	 public Employer(String email,String password,String companyName, String webAddress, String phoneNumber) {
	        super(email,password);
	        this.companyName = companyName;
	        this.webAddress = webAddress;
	        this.phoneNumber = phoneNumber;
	    }
}
