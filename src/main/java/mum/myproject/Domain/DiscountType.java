package mum.myproject.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;

@Inheritance
@Entity
public  class  DiscountType {
	@Id @GeneratedValue
	Long id;
	public  double getDiscount(){return 0;};
}
