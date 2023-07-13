package in.bitlogic.apnaloan.loan.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PropertyInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer propertyId;	
	private String propertyType;
	private String propertyArea;	
	private String constructionArea;	
	private Double propertyPrice;
	private Byte[] propertyDocuments;
	private Byte[] priceProofs;
	@OneToOne(cascade = CascadeType.ALL)
	private PropertyAddress propertyAddress;	

}
