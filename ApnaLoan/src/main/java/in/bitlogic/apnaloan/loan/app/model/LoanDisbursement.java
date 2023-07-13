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
class LoanDisbursement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer agreementId;
	private Integer loanNo;
	private String agreementDate;
	private String amountPayType;
		
	private String bankName;
	private Long accountNumber;
	private String IFSCCode;
	private String accountType;
	private Double transferAmount;
	private String amountPaidDate;

}
