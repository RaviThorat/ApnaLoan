package in.bitlogic.apnaloan.loan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.bitlogic.apnaloan.loan.app.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
