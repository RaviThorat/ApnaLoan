package in.bitlogic.apnaloan.loan.app.controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	//Get API Loan disbursed pdf for CM => http://localhost:9090/getLoanDisbursePdf/{cid}
	@GetMapping("/getLoanDisbursePdf/{cid}")
	public ResponseEntity<InputStreamResource> getLoanDisbursePdf(@PathVariable int cid){
		
		ByteArrayInputStream pdfArray = ls.createLoanDisbursePdf(cid);
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-Disposition", "Inline;filename=mypdf.pdf");
		
		return ResponseEntity.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(pdfArray));
	}
	
}
