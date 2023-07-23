package in.bitlogic.apnaloan.loan.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.bitlogic.apnaloan.loan.app.enums.EnquiryStatus;
import in.bitlogic.apnaloan.loan.app.model.EnquiryForm;
import in.bitlogic.apnaloan.loan.app.repository.EnquiryRepository;
import in.bitlogic.apnaloan.loan.app.service.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService{

	@Autowired
	EnquiryRepository er;	
	
	@Autowired
	RestTemplate rst;
	
	@Override
	public EnquiryForm addEnquiry(EnquiryForm e) {
		e.setStatus(String.valueOf(EnquiryStatus.NEW_ENQUIRY));
		return er.save(e);
	}

	@Override
	public List<EnquiryForm> getEnquiries() {
		
		return er.findAll();
	}

	@Override
	public List<EnquiryForm> getNewEnquiries(String status) {
		
		return er.findAllByStatus(status);
	}

	@Override
	public EnquiryForm requestCibil(int eid) {
		
		Optional<EnquiryForm> op=er.findById(eid);
					EnquiryForm ef=op.get();
					ef.setStatus(String.valueOf(EnquiryStatus.Cibil_REQUIRED));
		
		return er.save(ef);
	}

	@Override
	public EnquiryForm cibilScoreUpdate(int eid) {
		
				
		Optional<EnquiryForm> op=er.findById(eid);
				EnquiryForm e=op.get();
				
				
				int cibilScore=rst.getForObject("http://localhost:1010/cibilcalculator/getCibil/"+e.getPanCardNo(),Integer.class);
				
				e.setCibilScore(cibilScore);
				
				er.save(e);
				
				//Cibil Check Logic ---> Eligibility
				if(e.getCibilScore() >= 681) {
					e.setStatus(String.valueOf(EnquiryStatus.Cibil_OK));
				} else {
					e.setStatus(String.valueOf(EnquiryStatus.Cibil_NOTOK));
				}
			
		return er.save(e);
	}

}
