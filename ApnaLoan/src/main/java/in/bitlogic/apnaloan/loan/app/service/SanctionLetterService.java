package in.bitlogic.apnaloan.loan.app.service;

import java.io.ByteArrayInputStream;
import java.util.List;


import in.bitlogic.apnaloan.loan.app.model.Customer;
import in.bitlogic.apnaloan.loan.app.model.SanctionLetter;

public interface SanctionLetterService {

	public List<Customer> getVerifiedCustomers(String status);

	public Customer addSanctionData(SanctionLetter san, int cid);

	public ByteArrayInputStream getSanctionLetterPdf(int cid);


}
