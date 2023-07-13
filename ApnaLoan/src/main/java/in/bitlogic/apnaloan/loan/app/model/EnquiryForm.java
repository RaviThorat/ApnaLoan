package in.bitlogic.apnaloan.loan.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EnquiryForm {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cID;
	private String firstName;
	private String lastName;
	private Integer age;
	private String email;
	private Double mobileNo;
	private String status;
	// add enquiry status and cibil score

}
