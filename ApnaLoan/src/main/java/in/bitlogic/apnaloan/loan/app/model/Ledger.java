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
public class Ledger {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ledgerId;
	@CreationTimestamp
	private Date ledgerCreatedDate;
	private Double totalLoanAmount;
	private Double payableAmountwithInterest;
	private Integer tenure;
	private Double monthlyEMI;	
	private Double amountPaidtillDate;
	private Double remainingAmount;	
	private Date nextEmiDatestart;	
	@CreationTimestamp
	private Date nextEmiDateEnd;	
	private Integer defaulterCount; // no of emi bounce
	private String previousEmiStatus; // paid unpaid
	private String currentMonthEmiStatus;
	@CreationTimestamp
	private Date loanEndDate;
}
