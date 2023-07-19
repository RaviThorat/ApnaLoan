package in.bitlogic.apnaloan.loan.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.bitlogic.apnaloan.loan.app.model.EnquiryForm;
import in.bitlogic.apnaloan.loan.app.service.EnquiryService;

@RestController
public class EnquiryController {
	
	@Autowired
	EnquiryService es;
	
	//Post API for user=> http://localhost:9090/addEnquiry
	@PostMapping("/addEnquiry")
	public ResponseEntity<EnquiryForm> addEnquiry(@RequestBody EnquiryForm e) {
		
		return new ResponseEntity<EnquiryForm>(es.addEnquiry(e),HttpStatus.CREATED);
	}
	
	//Get API for RE => http://localhost:9090/getEnquiries
	@GetMapping("/getEnquiries")
	public ResponseEntity<List<EnquiryForm>> getEnquiries(){
		return new ResponseEntity<List<EnquiryForm>>(es.getEnquiries(),HttpStatus.OK);
	}
	
	//Get API for RE and OE => http://localhost:9090/getNewEnquiry/{status}
	@GetMapping("/getNewEnquiries/{status}")
	public ResponseEntity<List<EnquiryForm>> getNewEnquiries(@PathVariable String status) {
		return new ResponseEntity<List<EnquiryForm>>(es.getNewEnquiries(status),HttpStatus.OK);
	}
	
	//Put API Request Cibil for RE => http://localhost:9090/requestCibil/{eid}
	@PutMapping("/requestCibil/{eid}")
	public ResponseEntity<EnquiryForm> requestCibil(@PathVariable int eid) {
		return new ResponseEntity<EnquiryForm>(es.requestCibil(eid),HttpStatus.OK);
	}
	
	//Put API Cibil Score update for OE => http://localhost:9090/cibilScoreUpdate/{eid}
	@PutMapping("/cibilScoreUpdate/{eid}")
	public ResponseEntity<EnquiryForm> cibilScoreUpdate(@RequestBody EnquiryForm e, @PathVariable int eid){
		return new ResponseEntity<EnquiryForm>(es.cibilScoreUpdate(e,eid),HttpStatus.OK);
	}
	
	
}
