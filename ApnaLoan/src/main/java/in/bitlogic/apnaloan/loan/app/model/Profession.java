package in.bitlogic.apnaloan.loan.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Profession {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer professionid;
	private String professiontype;
	private Double professionsalary;
	private String professionsalaryType;
	private String professionworkingperiod;
	private String professionDesignation;
	private byte[] professionsalaryslips;

}
