package in.bitlogic.apnaloan.loan.app.service;

import java.util.List;
import java.util.Set;

import in.bitlogic.apnaloan.loan.app.model.Ledger;

public interface LedgerService {

Ledger addLedger(Ledger l);

List<Ledger> getLedger();

Set<Ledger> createLedger(int customerId);


}
