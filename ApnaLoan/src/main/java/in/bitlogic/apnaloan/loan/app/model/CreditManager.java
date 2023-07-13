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
public class CreditManager {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cmId;
	private String cmName;
	private String cmUsername;
	private String cmPassword;
}
