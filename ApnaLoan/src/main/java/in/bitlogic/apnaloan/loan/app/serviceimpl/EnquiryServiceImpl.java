package in.bitlogic.apnaloan.loan.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.bitlogic.apnaloan.loan.app.model.EnquiryForm;
import in.bitlogic.apnaloan.loan.app.repository.EnquiryRepository;
import in.bitlogic.apnaloan.loan.app.service.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService{

	@Autowired
	EnquiryRepository er;	
	
	@Override
	public void addEnquiry(EnquiryForm e) {
		e.setStatus("Updated");
		er.save(e);
	}

	@Override
	public List<EnquiryForm> getEnquiries() {
		
		return er.findAll();
	}

	@Override
	public List<EnquiryForm> getNewEnquiries(String status) {
		
		return er.findAllByStatus(status);
	}

}
