package in.bitlogic.apnaloan.loan.app.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.bitlogic.apnaloan.loan.app.enums.EnquiryStatus;
import in.bitlogic.apnaloan.loan.app.model.Customer;
import in.bitlogic.apnaloan.loan.app.model.CustomerVerification;
import in.bitlogic.apnaloan.loan.app.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService cs;
	
	//Post API for RE => http://localhost:9090/saveCustomer
	@PostMapping(value = "/saveCustomer", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Customer> saveCustomer(
			@RequestParam("addressProof") MultipartFile file1, 
			@RequestParam("panCard") MultipartFile file2, 
			@RequestParam("IncomeTax") MultipartFile file3,
			@RequestParam("addharCard") MultipartFile file4,
			@RequestParam("photo") MultipartFile file5,
			@RequestParam("signature") MultipartFile file6,
			@RequestParam("mortgagePropertyProof") MultipartFile file7,
			@RequestParam("professionsalaryslips") MultipartFile file8,
			@RequestParam("propertyDocuments") MultipartFile file9,
			@RequestParam("data") String json) throws IOException{
		
		ObjectMapper om=new ObjectMapper();		
		Customer cust= om.readValue(json, Customer.class);
				 cust.getAllpersonalDoc().setAddressProof(file1.getBytes());
				 cust.getAllpersonalDoc().setPanCard(file2.getBytes());
				 cust.getAllpersonalDoc().setIncomeTax(file3.getBytes());
				 cust.getAllpersonalDoc().setAddharCard(file4.getBytes());
				 cust.getAllpersonalDoc().setPhoto(file5.getBytes());
				 cust.getAllpersonalDoc().setSignature(file6.getBytes());
				 cust.getMortgageDetails().setMortgagePropertyProof(file7.getBytes());
				 cust.getProfession().setProfessionsalaryslips(file8.getBytes());
				 cust.getPropertyinfo().setPropertyDocuments(file9.getBytes());
				
		return new ResponseEntity<Customer>(cs.saveCustomer(cust),HttpStatus.CREATED);
	}
	
	// Get API for OE => http://localhost:9090/getCustomers
	@GetMapping("/getCustomers")
	public ResponseEntity<List<Customer>> getCustomers(){
		return new ResponseEntity<List<Customer>>(cs.getCustomers(),HttpStatus.OK);
	}
	
	// Get API single customer for OE Document Verification => http://localhost:9090/getCustomer/{cid}
	@GetMapping("/getCustomer/{cid}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int cid){
		return new ResponseEntity<Customer>(cs.getCustomer(cid),HttpStatus.OK);
	}
	
	// Put API customer verification for OE => http://localhost:9090/customerDocVerification/{cid}
	@PutMapping("/customerDocVerification/{cid}")
	public ResponseEntity<Customer> customerDocVerification(@RequestBody CustomerVerification cv,@PathVariable int cid){
		return new ResponseEntity<Customer>(cs.customerDocVerification(cv,cid), HttpStatus.OK);
	}
	
}
