package in.bitlogic.apnaloan.loan.app.service;



public interface EmailSenderService {

	public void sendEmailWithAttachedment(String fEmail, int customerId);

	public void sendEmailLoanDisbursement(String fEmail, int customerId);

}
