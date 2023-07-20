package in.bitlogic.apnaloan.loan.app.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.bitlogic.apnaloan.loan.app.model.Customer;
import in.bitlogic.apnaloan.loan.app.model.LoanDisbursement;
import in.bitlogic.apnaloan.loan.app.repository.CustomerRepository;
import in.bitlogic.apnaloan.loan.app.service.LoanDisbursementService;

@Service
public class LoanDisbursementServiceImpl implements LoanDisbursementService{

	@Autowired
	CustomerRepository cr;
	
	
	@Override
	public Customer saveLoanDisburse(LoanDisbursement ld, int cid) {
		
		Optional<Customer> op=cr.findById(cid);
				Customer c=op.get();
				
				ld.setLoanNo(ld.getAgreementId());
				ld.setModeOfPayment(c.getSanctionletter().getModeOfPayment());
				ld.setBankName(c.getAccountdetails().getBankName());
				ld.setBankBranchName(c.getAccountdetails().getBankBranchName());
				ld.setAccountHolderFirstName(c.getSanctionletter().getApplicantFirstName());
				ld.setAccountHolderMiddleName(c.getSanctionletter().getApplicantMiddleName());
				ld.setAccountHolderLastName(c.getSanctionletter().getApplicantLastName());
				ld.setAccountNumber(c.getAccountdetails().getAccountNumber());
				ld.setIfscCode(c.getAccountdetails().getAccountIfscNumber());
				ld.setAccountType(c.getAccountdetails().getAccounType());
				ld.setTransferAmount(c.getSanctionletter().getLoanAmtSanctioned());
				
				c.setLoandisbursement(ld);
		
		return cr.save(c);
	}

}
