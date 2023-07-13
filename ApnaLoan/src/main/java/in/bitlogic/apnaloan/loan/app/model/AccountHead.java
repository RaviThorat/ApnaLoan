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
public class AccountHead {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ahId;
	private String ahName;
	private String ahUsername;
	private String ahPassword;
}
