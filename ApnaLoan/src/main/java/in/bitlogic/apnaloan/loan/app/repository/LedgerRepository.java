package in.bitlogic.apnaloan.loan.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.bitlogic.apnaloan.loan.app.model.Ledger;

public interface LedgerRepository extends JpaRepository<Ledger, Integer>
{
	public List<Ledger> findAllByStatus(String status);

}
