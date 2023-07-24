package in.bitlogic.apnaloan.loan.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.bitlogic.apnaloan.loan.app.model.EmailSender;
import in.bitlogic.apnaloan.loan.app.service.EmailSenderService;

@RestController
public class EmailSenderController {

	@Autowired
	EmailSenderService ess;
	
	@Value("${spring.mail.username}")
	String fEmail;
	

	//Post API Sanction letter send for CM => http://localhost:9090/emailsendsanctionletter/{customerId}

    @GetMapping(value="/emailsendsanctionletter/{customerId}")
	public String sendEmailWithAttachedment(@PathVariable("customerId") int customerId) 
	{  	   	
     	try
    	{
    		ess.sendEmailWithAttachedment(fEmail,customerId);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		System.out.println("Email is not send");  		
    	}    	
    	return "Email Send Successfully";
	}	
    
    
	//Post API Loan Disbursement letter send for CM => http://localhost:9090/emailsendsanctionletter/{customerId}

    @GetMapping(value="/emailsendloandisbursement/{customerId}")
   	public String sendEmailLoanDisbursement(@PathVariable("customerId") int customerId) 
   	{  	   	
        	try
       	{
       		ess.sendEmailLoanDisbursement(fEmail,customerId);
       	}
       	catch(Exception e)
       	{
       		e.printStackTrace();
       		System.out.println("Email is not send");  		
       	}    	
       	return "Email Send Successfully";
   	}	
}
