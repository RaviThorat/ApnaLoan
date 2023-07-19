package in.bitlogic.apnaloan.loan.app.serviceimpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.bitlogic.apnaloan.loan.app.enums.EnquiryStatus;
import in.bitlogic.apnaloan.loan.app.model.Customer;
import in.bitlogic.apnaloan.loan.app.model.CustomerVerification;
import in.bitlogic.apnaloan.loan.app.repository.CustomerRepository;
import in.bitlogic.apnaloan.loan.app.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository cr;
	
	@Override
	public Customer saveCustomer(Customer c) {
		
		if(c.getCbscore().getCibilScore() >= 681) {
			c.setCustomerStatus(String.valueOf(EnquiryStatus.Customer_CREATED));
			return cr.save(c);
		} else {
			c.setCustomerStatus(String.valueOf(EnquiryStatus.Customer_NOTCREATED));
			return null;
		}
	}

	@Override
	public List<Customer> getCustomers() {
		
		return cr.findAll();
	}

	@Override
	public Customer getCustomer(int cid) {
		
		Optional<Customer> op=cr.findById(cid);
					if(op.isPresent()) {						
						return op.get();
					} else {
						return null;
					}
	}

	@Override
	public Customer customerDocVerification( CustomerVerification cv,int cid) {
		Optional<Customer> op=cr.findById(cid);
		Customer c=op.get();
		c.setCustomerStatus(String.valueOf(EnquiryStatus.File_PENDING));
		cv.setVerificationDate(new Date());
		cv.setStatus(String.valueOf(EnquiryStatus.Customer_VERIFIED));
		
		c.setCustomerverification(cv);
		
		return cr.save(c);
	}

}
