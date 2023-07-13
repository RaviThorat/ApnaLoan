package in.bitlogic.apnaloan.loan.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.bitlogic.apnaloan.loan.app.model.EnquiryForm;

@Repository
public interface EnquiryRepository extends JpaRepository<EnquiryForm, Integer>{
	public List<EnquiryForm> findAllByStatus(String status);
}
