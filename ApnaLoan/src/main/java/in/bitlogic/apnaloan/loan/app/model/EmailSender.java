package in.bitlogic.apnaloan.loan.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailSender {		
	private String formEmail;
	private String toEmail;
	private String subject;
	private String textMessage; 
}
