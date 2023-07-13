package in.bitlogic.apnaloan.loan.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.bitlogic.apnaloan.loan.app.model.Customer;
import in.bitlogic.apnaloan.loan.app.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService cs;
	
	//Post API => http://localhost:9090/saveCustomer
	@PostMapping("/saveCustomer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer c){
		
		Customer cust=cs.saveCustomer(c);
		
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	
	
}
