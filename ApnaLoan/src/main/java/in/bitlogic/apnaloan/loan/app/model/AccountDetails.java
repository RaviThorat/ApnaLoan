package in.bitlogic.apnaloan.loan.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AccountDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountId;
	private String accounType;
	private String bankName;
	private String bankBranchName;
	private Long accountNumber;
	private String accountHolderFirstName;
	private String accountHolderMiddleName;
	private String accountHolderLastName;
	private String accountIfscNumber;
	private Double accountBalance;
}
