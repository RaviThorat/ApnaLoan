package in.bitlogic.apnaloan.loan.app.service;

import in.bitlogic.apnaloan.loan.app.model.Customer;
import in.bitlogic.apnaloan.loan.app.model.LoanDisbursement;

public interface LoanDisbursementService {

	Customer saveLoanDisburse(LoanDisbursement ld, int cid);

}
