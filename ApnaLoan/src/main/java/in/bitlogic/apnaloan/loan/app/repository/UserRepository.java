package in.bitlogic.apnaloan.loan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.bitlogic.apnaloan.loan.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
