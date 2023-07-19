package in.bitlogic.apnaloan.loan.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

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
	@CreationTimestamp
	private Date agreementDate;
	private String modeOfPayment;
	private String bankName;
	private String bankBranchName;
	private String accountHolderFirstName;
	private String accountHolderMiddleName;
	private String accountHolderLastName;
	private Long accountNumber;
	private String ifscCode;
	private String accountType;
	private Double transferAmount;
	private Date amountPaidDate;
}
