package mum.myproject.Controllers;

import java.util.List;

import org.springframework.stereotype.Component;

import mum.myproject.Domain.Reservation;
import mum.myproject.Domain.Room;

@Component
public class PriceCalculator {
	public double calculatePrice(Reservation res){
		List<Room> rooms=res.getAllrooms();
		if(rooms==null)return 0;
		double sum=0;
		for(Room room:rooms){
			sum=sum+room.getRoomtype().getRoomtypeprice();
		}
		Long diffmis= res.getCheckOutDate().getTime()-res.getCheckInDate().getTime();
		Long datediff=diffmis/(1000*60*60*24);
		System.out.println(datediff);
		sum=sum*(datediff);
		sum=sum-sum*getDiscount(res);
		return calculateTax(sum);
	}
	public double getDiscount(Reservation res){
		return res.getDiscount().getDiscountType().getDiscount();
	}
	public double calculateTax(double totalprice){
		return totalprice+0.1*totalprice;
	}
}
