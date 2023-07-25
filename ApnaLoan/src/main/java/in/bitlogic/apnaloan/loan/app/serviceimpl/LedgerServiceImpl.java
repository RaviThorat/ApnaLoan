package in.bitlogic.apnaloan.loan.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.bitlogic.apnaloan.loan.app.model.Customer;
import in.bitlogic.apnaloan.loan.app.model.Ledger;
import in.bitlogic.apnaloan.loan.app.model.SanctionLetter;
import in.bitlogic.apnaloan.loan.app.repository.CustomerRepository;
import in.bitlogic.apnaloan.loan.app.repository.LedgerRepository;
import in.bitlogic.apnaloan.loan.app.service.LedgerService;

@Service
public class LedgerServiceImpl implements LedgerService
{

	
	@Autowired
    LedgerRepository lr;	
	@Autowired
     CustomerRepository cr;

	@Override
	public Ledger addLedger(Ledger l) {
		return lr.save(l);
	}

	@Override
	public List<Ledger> getLedger() {
		return lr.findAll();
	}

	@Override
	public List<Ledger> createLedger(int customerId) {
             Optional<Customer> optionalCustomer = cr.findById(customerId);
             if(optionalCustomer.isPresent())
             {
            	 Customer customer=optionalCustomer.get();
            	 SanctionLetter sanction=customer.getSanctionletter();
            	 
            	 for(int i=1;i<=sanction.getLoanTenureInYears()*12;i++)
            	 {
            		 if(customer.getLedger()==null);
            		 {
            			 System.out.println("ok");
            		 }
            	 }
            	 
             }
               
		return null;
	}

}
