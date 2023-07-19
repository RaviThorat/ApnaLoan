package in.bitlogic.apnaloan.loan.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.bitlogic.apnaloan.loan.app.enums.EnquiryStatus;
import in.bitlogic.apnaloan.loan.app.model.EnquiryForm;
import in.bitlogic.apnaloan.loan.app.repository.EnquiryRepository;
import in.bitlogic.apnaloan.loan.app.service.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService{

	@Autowired
	EnquiryRepository er;	
	
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
	public EnquiryForm cibilScoreUpdate(EnquiryForm e, int eid) {
		
				
		Optional<EnquiryForm> op=er.findById(eid);
				EnquiryForm eform=op.get();
				
				e.setEID(eid);
				e.setFirstName(eform.getFirstName());
				e.setLastName(eform.getLastName());
				e.setAge(eform.getAge());
				e.setEmail(eform.getEmail());
				e.setMobileNo(eform.getMobileNo());				
				e.setPanCardNo(eform.getPanCardNo());
//				e.setCibilScore(eform.getCibilScore());
				
				er.save(e);
				
//				eform.setCibilScore(785);
				//Cibil Check Logic ---> Eligibility
				if(eform.getCibilScore() >= 681) {
					eform.setStatus(String.valueOf(EnquiryStatus.Cibil_OK));
				} else {
					eform.setStatus(String.valueOf(EnquiryStatus.Cibil_NOTOK));
				}
			
		return er.save(eform);
	}

}
