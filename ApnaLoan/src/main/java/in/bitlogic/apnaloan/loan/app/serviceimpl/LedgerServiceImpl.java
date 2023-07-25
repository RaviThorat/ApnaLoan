package in.bitlogic.apnaloan.loan.app.serviceimpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ch.qos.logback.classic.pattern.RootCauseFirstThrowableProxyConverter;
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
	public Set<Ledger> createLedger(int customerId) {
             Optional<Customer> optionalCustomer = cr.findById(customerId);
             if(optionalCustomer.isPresent())
             {
            	 Customer customer=optionalCustomer.get();
            	 SanctionLetter sanction=customer.getSanctionletter();
            	 
            	 for(int i=0;i<sanction.getLoanTenureInYears()*12;i++)
            	 {
            		 if( customer.getLedger().size()<=0)
            		 {
            			Ledger firstEmi=new Ledger();
            			firstEmi.setLedgerId(String.valueOf(customer.getCustomerId())+"EmiNo-"+i);
            	
            			firstEmi.setTotalLoanAmount(sanction.getLoanAmtSanctioned());
            			firstEmi.setPayableAmountwithInterest(sanction.getTotalAmountWithInterest());
            			firstEmi.setLoanTenureInYears(sanction.getLoanTenureInYears());
            			firstEmi.setMonthlyEMI(sanction.getMonthlyEmiAmount());
        
            			firstEmi.setRemainingAmount(sanction.getTotalAmountWithInterest());
            			
            			Date todayDate=new Date();
            		int month=	todayDate.getMonth();
            			int year =todayDate.getYear();
            			if(month<12) {
            		    firstEmi.setNextEmiDateStart("01/"+month+1+"/"+year);
            		    firstEmi.setNextEmiDateEnd("30/"+month+1+"/"+year);
            			}else {
            				  firstEmi.setNextEmiDateStart("01/"+1+"/"+year+1);
                  		    firstEmi.setNextEmiDateEnd("30/"+1+"/"+year+1);
            			}
            			firstEmi.setDefaulterCount(0);
            			DateFormat format=new SimpleDateFormat("dd-MM-YYYY");
            			     
            			firstEmi.setLoanEmiStartDate(format.format(todayDate));
            			String startDate=format.format(todayDate);
            			int lenth=startDate.length();
                char ch=			startDate.charAt(lenth-1);
                 Integer lastEmiChar=(ch-'0')+sanction.getLoanTenureInYears();
         			firstEmi.setLoanEmiEndDate(startDate.replace(ch, lastEmiChar.toString().charAt((0))));
         			firstEmi.setNoOfEmisPaid(0);
         			firstEmi.setTotalNoOfEmi(sanction.getLoanTenureInYears()*12);
         			firstEmi.setRemainingEmi(sanction.getLoanTenureInYears()*12);
         			customer.getLedger().add(firstEmi);
         			
         			}
            		 else {
            			 
            			   List<Ledger> ledgerList = customer.getLedger().stream().collect(Collectors.toList());
            			                 Ledger lastEmi = ledgerList.get(i-1);
            			                 
            			                 
            			                 Ledger newEmi=new Ledger();
            			                 newEmi.setLedgerId(String.valueOf(customer.getCustomerId())+"EmiNo-"+i);
            		            	
            			                 newEmi.setTotalLoanAmount(sanction.getLoanAmtSanctioned());
            			                 newEmi.setPayableAmountwithInterest(sanction.getTotalAmountWithInterest());
            			                 newEmi.setLoanTenureInYears(sanction.getLoanTenureInYears());
            			                 newEmi.setMonthlyEMI(sanction.getMonthlyEmiAmount());
            		            	
            			                 newEmi.setRemainingAmount(lastEmi.getRemainingAmount()-sanction.getMonthlyEmiAmount());
            			                 
            			                 
            			                 String lastEmiSartDate=lastEmi.getLoanEmiEndDate();
            			                  DateFormat dateFormat=new SimpleDateFormat("dd-MM-YYYY");
            			                    Date lastDateEnd;
											try {
												System.out.println(lastEmiSartDate);
												lastDateEnd = (Date) dateFormat.parse(lastEmiSartDate);
											     int month=  lastDateEnd.getMonth();
		            			                  int year=lastDateEnd.getYear();
		            			          		if(month<11) {
		            			          			newEmi.setNextEmiDateStart("01/"+month+1+"/"+year);
		            		            		    newEmi.setNextEmiDateEnd("30/"+month+1+"/"+year);
		            		            			}else {
		            		            				newEmi.setNextEmiDateStart("01/"+1+"/"+year+1);
		            		            				newEmi.setNextEmiDateEnd("30/"+1+"/"+year+1);
		            		            			}
		            			                 
											} catch (ParseException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
            			             

            			          		newEmi.setDefaulterCount(0);
            		            			DateFormat format=new SimpleDateFormat("dd-MM-YYYY");
            		            			     
            		            			newEmi.setLoanEmiStartDate(lastEmi.getLoanEmiStartDate());
            		     
            		            			newEmi.setLoanEmiEndDate(lastEmi.getLoanEmiEndDate());
            		            			newEmi.setNoOfEmisPaid(0);
            		            			newEmi.setTotalNoOfEmi(sanction.getLoanTenureInYears()*12);
            		            			newEmi.setRemainingEmi(sanction.getLoanTenureInYears()*12);
            		         			customer.getLedger().add(newEmi);
            		         		
            			                 
            			 }
            		 
            	 }
            	 System.out.println(customer.getLedger());
            	 
            	 return customer.getLedger() ;
             }
               
            return null;
	}

}
