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
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String customerName;
	private String customerDateOfBirth;
	private Integer customerAge;
	private String customerGender;
	private String customerEmail;
	private Double customerMobileNumber;	
	private Double customerAdditionalMobileNumber;
	private Double customerTotalLoanRequired;
	
	@OneToOne(cascade = CascadeType.ALL)
	private EducationalInformation educationalInfo;
	@OneToOne(cascade = CascadeType.ALL)
	private AllPersonalDocuments allpersonalDoc;
	@OneToOne(cascade = CascadeType.ALL)
	private FamilyDependentInforamtion familydependentInfo;
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerAddress customerAddress;
	@OneToOne(cascade = CascadeType.ALL)
	private MortgageDetails mortgageDetails;
	@OneToOne(cascade = CascadeType.ALL)
	private Profession profession;
	@OneToOne(cascade = CascadeType.ALL)
	private Cibil cibilscore;
	@OneToOne(cascade = CascadeType.ALL)
	private AccountDetails accountdetails;
	@OneToOne(cascade = CascadeType.ALL)
	private PropertyInfo propertyinfo;
	@OneToOne(cascade = CascadeType.ALL)
	private GuarantorDetails gurantordetails;
	@OneToOne(cascade = CascadeType.ALL)
	private LoanDisbursement loandisbursement;
	@OneToOne(cascade = CascadeType.ALL)
	private Ledger ledger;
	@OneToOne(cascade = CascadeType.ALL)
	private SanctionLetter sanctionletter;
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerVerification customerverification;

}
