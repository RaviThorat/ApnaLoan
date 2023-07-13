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

public class SanctionLetter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sanctionId;
	private String sanctionDate;
	private String applicantName;	
	private Double contactDetails;	
		
	private Double loanAmtSanctioned;
	private String interestType;
	private Integer rateOfInterest;	
	private Integer loanTenure;	
	private Double monthlyEmiAmount;
	private String modeOfPayment;	
	private String remarks;	
	private String termsCondition;	
	private String status;	

}
