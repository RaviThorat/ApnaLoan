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
public class AllPersonalDocuments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer documentID;
	private byte[] addressProof;
	private byte[] panCard;
	private byte[] IncomeTax;
	private byte[] addharCard;
	private byte[] photo;
	private byte[] signature;
	private byte[] salarySlips;

}
