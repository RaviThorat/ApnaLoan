package in.bitlogic.apnaloan.loan.app.service;

import java.io.ByteArrayInputStream;

import in.bitlogic.apnaloan.loan.app.model.Customer;
import in.bitlogic.apnaloan.loan.app.model.LoanDisbursement;

public interface LoanDisbursementService {

	public Customer saveLoanDisburse(LoanDisbursement ld, int cid);

	public ByteArrayInputStream createLoanDisbursePdf(int cid);



}
