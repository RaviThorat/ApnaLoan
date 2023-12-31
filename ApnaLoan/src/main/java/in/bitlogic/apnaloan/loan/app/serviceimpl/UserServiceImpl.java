package in.bitlogic.apnaloan.loan.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.bitlogic.apnaloan.loan.app.model.User;
import in.bitlogic.apnaloan.loan.app.repository.UserRepository;
import in.bitlogic.apnaloan.loan.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository ur;
	
	@Override
	public User createUser(User u) {
		
		String fInitial=String.valueOf(u.getUserFirstName().charAt(0));
		String lChar=String.valueOf(u.getUserLastName().charAt(2));
		String eChar=String.valueOf(u.getUserEmail().charAt(5));
		String dChar=String.valueOf(u.getUserDesignation().charAt(4));
		String charSeq=(String)u.getUserDesignation().subSequence(3, 5);
		
		String uname=fInitial+lChar.toLowerCase()+eChar+dChar.toUpperCase()+charSeq;
		u.setUserUsername(uname);
		
		String passfInitial=String.valueOf(u.getUserFirstName().charAt(1));
		String passlChar=String.valueOf(u.getUserLastName().charAt(0));
		String passeChar=String.valueOf(u.getUserEmail().charAt(3));
		String passdChar=String.valueOf(u.getUserDesignation().charAt(2));
		String passcharSeq=(String)u.getUserDesignation().subSequence(1, 3);
		
		String pass=passfInitial+passlChar+passeChar+passdChar+passcharSeq;
		u.setUserPassword(pass);
		
		return ur.save(u);
	}

}
