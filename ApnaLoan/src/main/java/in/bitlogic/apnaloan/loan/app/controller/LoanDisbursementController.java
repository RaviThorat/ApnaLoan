package in.bitlogic.apnaloan.loan.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.bitlogic.apnaloan.loan.app.model.Customer;
import in.bitlogic.apnaloan.loan.app.model.LoanDisbursement;
import in.bitlogic.apnaloan.loan.app.service.LoanDisbursementService;

@RestController
public class LoanDisbursementController {
	
	@Autowired
	LoanDisbursementService ls;
	
	//Put API Loan Disbursement for CM => http://localhost:9090/saveLoanDisburse/{cid}
	@PutMapping("/saveLoanDisburse/{cid}")
	public ResponseEntity<Customer> saveLoanDisburse(@RequestBody LoanDisbursement ld, @PathVariable int cid){
		return new ResponseEntity<Customer>(ls.saveLoanDisburse(ld,cid),HttpStatus.OK);
	}
	
	
}
