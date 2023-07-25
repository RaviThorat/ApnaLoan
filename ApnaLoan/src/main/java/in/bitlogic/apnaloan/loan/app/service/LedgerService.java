package in.bitlogic.apnaloan.loan.app.service;

import java.util.List;
import java.util.Set;

import in.bitlogic.apnaloan.loan.app.model.Ledger;

public interface LedgerService {

public Ledger addLedger(Ledger l);

public List<Ledger> getLedger();

public List<Ledger> createLedger(int customerId);


}
