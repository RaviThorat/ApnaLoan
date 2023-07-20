package in.bitlogic.apnaloan.loan.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.bitlogic.apnaloan.loan.app.model.Customer;
import in.bitlogic.apnaloan.loan.app.model.EnquiryForm;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	public List<Customer> findAllByCustomerStatus(String status);
}
