package in.bitlogic.apnaloan.loan.app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.bitlogic.apnaloan.loan.app.model.Customer;
import in.bitlogic.apnaloan.loan.app.model.Ledger;
import in.bitlogic.apnaloan.loan.app.repository.CustomerRepository;
import in.bitlogic.apnaloan.loan.app.service.LedgerService;

@CrossOrigin("*")
@RestController
public class LedgerController 
{
	@Autowired
LedgerService ls;
	



//Post API for Ledger=> http://localhost:9090/addLedger
	@PostMapping("/addLedger")
public ResponseEntity<Ledger> saveLedger(@RequestBody Ledger l)
{
	return new ResponseEntity<Ledger>(ls.addLedger(l),HttpStatus.CREATED);
		
}
	
	
//Get API for Ledger => http://localhost:9090/getLedger
		@GetMapping("/getLedger")
		public ResponseEntity<List<Ledger>> getLedger()
		{
			return new ResponseEntity<List<Ledger>>(ls.getLedger(),HttpStatus.OK);
		}
		
        @GetMapping("/generateLedger/{customerId}")
        public Set<Ledger> genrateLedger(@PathVariable int customerId)
        {
           Set<Ledger> ledgers=	ls.createLedger(customerId);
        	
        	
        	return ledgers;
        }
		
//		
////[1]		
//		private List<Ledger> ledgerEntries = new ArrayList<>();
//
//	    // Endpoint to get all ledger entries
//		
//	    @GetMapping
//	    public List<Ledger> getAllLedgerEntries() {
//	        return ledgerEntries;
//	    }
//	    
//	    
//	    
////[2]		
//	    // Endpoint to get a specific ledger entry by ID
//	    @GetMapping("/{id}")
//	    public ResponseEntity<Ledger> getLedgerById(@PathVariable Integer ledgerId) {
//	        Ledger entry = findByLedgerId(ledgerId);
//	        if (entry != null) {
//	            return new ResponseEntity<>(entry, HttpStatus.OK);
//	        } else {
//	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	        }
//	    }
//
//	  
////[3]	    
//	    // Endpoint to create a new ledger entry
//	    @PostMapping
//	    public ResponseEntity<Ledger> addLedger(@RequestBody Ledger entry) {
//	     
//	   
//
//	      
//	     // Add the entry to the ledger
//	        ledgerEntries.add(entry);
//
//	     // Return the newly created entry with status 201 Created
//	        return new ResponseEntity<>(entry, HttpStatus.CREATED);
//	    }

		
		
		
		
		
		// Method to handle HTTP POST request to record a new transaction
	   
//		public void recordTransaction(String transactionId, String loanId, double amount, LocalDate date) {
//	        Transaction newTransaction = new Transaction(transactionId, loanId, amount, date);
//	        loanLedger.recordTransaction(newTransaction);
//	    }
//
//	   
//		// Method to handle HTTP GET request to retrieve loan details by loanId
//	  
//		public Loan getLoanDetails(String loanId) {
//	        return loanLedger.getLoanDetails(loanId);
//	    }
//
//	   
//		// Method to handle HTTP GET request to retrieve transaction history by loanId
//	    
//		public List<Transaction> getTransactionHistory(String loanId) {
//	        return loanLedger.getTransactionHistory(loanId);
//	    }

		
		
//		Integer ledgerId;
//		Date ledgerCreatedDate;
//		Double totalLoanAmount;
//		 Double payableAmountwithInterest;
//		 Integer loanTenureInYears;
//		 Double monthlyEMI;	
//		 Double amountPaidTillDate;
//		 Double remainingAmount;
//		 String nextEmiDateStart;	
//		 String nextEmiDateEnd;	
//		 Integer defaulterCount; // no of emi bounce
//         Date currentEmiPaidDate;
//		 String currentEmiPaidMode;
//		 String previousEmiStatus; // paid unpaid
//		 String currentMonthEmiStatus;
//		 String loanEmiStartDate;
//		 String loanEmiEndDate;
//		 Integer noOfEmisPaid;
//		 Integer totalNoOfEmi;
//		 Integer remainingEmi;

		
		
		
		//remainingEmi=totalNoOfEmi-noOfEmisPaid;
		//payableAmountwithInterest / remainingAmount=totalLoanAmount-amountPaidTillDate;

		
		
		
//	***************************INCASE PUT-MAPPING REQUIRED*****************************************************************************************************
		
		
//		@PutMapping("/updateLedger/{cusid}")
//		public ResponseEntity<Customer> updateLedger(@PathVariable("cusid") Integer cusid,@RequestBody Ledger ledger){
//			Customer findById = ls.findById(cusid);
//			Customer customer = findById.get();
//			if(findById.isPresent()) {
//			
//				customer.setLedger(ledger);
//				
//			
//			}else {
//				throw new Exception();
//			}
//			Customer saveLedger = ls.saveLedger(customer);
////			BaseResponse baseResponse=new BaseResponse(200,"Ledger & EMI data Updated successfully!!",saveLedger);
//			return new ResponseEntity<Customer>(HttpStatus.OK);
//		}

//*************************************************************************************************************

		
//**************************************************************************************************
//		

//		public Ledger getBalance(@RequestParam(name = "address", required = true)
//		                 @PathParam("address") String address)
//		{
//		  byte[] addressBytes = null;
//		
	//		try 
//			{
//		    addressBytes = AddressTool.getAddress(address);
//		     }
//				catch (Exception e) {
//		    return Result.getFailed(AccountErrorCode.ADDRESS_ERROR).toRpcClientResult();
//		  }
//		  if (addressBytes.length != Address.ADDRESS_LENGTH) {
//		    return Result.getFailed(AccountErrorCode.ADDRESS_ERROR).toRpcClientResult();
//		  }
//		  Result result = accountLedgerService.getBalance(addressBytes);
//		  return result.toRpcClientResult();
//		}
//		AccountResource.getAssets(...)
//		Result<Balance> balanceResult = accountLedgerService.getBalance(addr.getAddressBytes());
//		if (balanceResult.isFailed()) {
//		  return balanceResult.toRpcClientResult();
//		dto.setTotalDeposit(totalDeposit);
//		try {
//		  dto.setUsableBalance(accountLedgerService.getBalance(addressBytes).getData().getUsable().getValue());
//		} catch (Exception e) {
//		  Log.error(e);
//		AccountServiceImpl.getBalance()
//		@Override
//		public Result<Balance> getBalance() throws NulsException {
//		  List<Account> list = new ArrayList<>();
//		  Balance balance = new Balance();
//		  Result<List<AccountPo>> result = accountStorageService.getAccountList();
//		  if (result.isFailed()) {
//		    return Result.getFailed().setData(balance);
//		  }
//		  List<AccountPo> poList = result.getData();
//		  if (null == poList || poList.isEmpty()) {
//		    return Result.getFailed(AccountErrorCode.ACCOUNT_NOT_EXIST);
//		  }
//		  for (AccountPo po : poList) {
//		    Account account = po.toAccount();
//		    list.add(account);
//		  }
//		  for (Account account : list) {
//		    Result<Balance> resultBalance = accountLedgerService.getBalance(account.getAddress().getAddressBytes());
//		    if (resultBalance.isSuccess()) {
//		      Balance temp = resultBalance.getData();
//		      if (null == temp) {
//		        continue;
//		      }
//		      balance.setBalance(balance.getBalance().add(temp.getBalance()));
//		      balance.setLocked(balance.getLocked().add(temp.getLocked()));
//		      balance.setUsable(balance.getUsable().add(temp.getUsable()));
//		    }
//		  }
//		  return Result.getSuccess().setData(balance);
//		}
		
//**************************************************************************************************************		
		
//		
		
		
		}
