package in.bitlogic.apnaloan.loan.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.bitlogic.apnaloan.loan.app.model.Customer;
import in.bitlogic.apnaloan.loan.app.repository.CustomerRepository;
import in.bitlogic.apnaloan.loan.app.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository cr;
	
	@Override
	public Customer saveCustomer(Customer c) {
		
		return cr.save(c);	
	}

}
