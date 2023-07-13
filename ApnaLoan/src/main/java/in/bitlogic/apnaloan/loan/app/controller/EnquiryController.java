package in.bitlogic.apnaloan.loan.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.bitlogic.apnaloan.loan.app.model.EnquiryForm;
import in.bitlogic.apnaloan.loan.app.service.EnquiryService;

@RestController
public class EnquiryController {
	
	@Autowired
	EnquiryService es;
	
	//Post API => http://localhost:9090/addEnquiry
	@PostMapping("/addEnquiry")
	public String addEnquiry(@RequestBody EnquiryForm e) {
		
		es.addEnquiry(e);
		
		return "Enuiry Submitted";
	}
	
	//Get API => http://localhost:9090/getEnquiries
	@GetMapping("/getEnquiries")
	public List<EnquiryForm> getEnquiries(){
		return es.getEnquiries();
	}
	
	//Get API => http://localhost:9090/getNewEnquiry/{status}
	@GetMapping("/getNewEnquiries/{status}")
	public List<EnquiryForm> getNewEnquiries(@PathVariable String status) {
		return es.getNewEnquiries(status);
	}
	
	
	
	
}
