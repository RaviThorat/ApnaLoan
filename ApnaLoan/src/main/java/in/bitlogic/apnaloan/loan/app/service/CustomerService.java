package in.bitlogic.apnaloan.loan.app.service;

import java.util.List;

import in.bitlogic.apnaloan.loan.app.model.Customer;
import in.bitlogic.apnaloan.loan.app.model.CustomerVerification;

public interface CustomerService {

	public Customer saveCustomer(Customer c);

	public List<Customer> getCustomers();

	public Customer getCustomer(int cid);

	public Customer customerDocVerification( CustomerVerification cv, int cid);

	public List<Customer> getCreatedCustomers(String customerStatus);
}
