package in.bitlogic.apnaloan.loan.app.service;

import java.util.List;

import in.bitlogic.apnaloan.loan.app.model.Ledger;

public interface LedgerService {

Ledger addLedger(Ledger l);

List<Ledger> getLedger();

List<Ledger> createLedger(int customerId);


}
