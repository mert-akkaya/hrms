package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employer_update_contents")
@TypeDefs({
	@TypeDef(name = "json",typeClass = JsonType.class),
	@TypeDef(name="jsonb",typeClass = JsonBinaryType.class)
})
public class EmployerUpdateContent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="employer_id")
	private int employerId;
	
	@Column(name="content",columnDefinition = "json")
	@Type(type = "json")
	private Employer content;
	
	@Column(name="status")
	private boolean status;
}
