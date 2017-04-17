package mum.myproject.Domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Discount 
{
	@Id @GeneratedValue
	Long id;
	@OneToOne (cascade = CascadeType.ALL)
	DiscountType discountType;
	public Discount(){
		
	};
	public Discount(DiscountType discounttype){
		this.discountType=discounttype;
	}
	public double getDiscount(){
		return discountType.getDiscount();
	}

	public DiscountType getDiscountType() {
		return discountType;
	}

	public void setDiscountType(DiscountType discountType) {
		this.discountType = discountType;
	}
}
