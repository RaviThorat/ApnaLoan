package in.bitlogic.apnaloan.loan.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	private String userFirstName;
	private String userLastName;
	private String userUsername; // auto generated
	private String userPassword; // auto generated
	private String userEmail;
	@OneToOne(cascade = CascadeType.ALL)
	private UserDocuments userDocs;
	
}
