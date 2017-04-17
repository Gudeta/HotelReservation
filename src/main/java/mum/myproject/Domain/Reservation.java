package mum.myproject.Domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Entity
public class Reservation {
	@Id	@GeneratedValue
	public Long reservationId;
	private Date checkInDate;
	boolean isCheckdedout=false;
	private Date checkOutDate;
//	private int numberOfAdult;
	private double totalPrice;
	private boolean paymentStatus;
	@OneToOne (cascade = CascadeType.ALL)
	private Discount discount;
	
	
	public boolean isCheckdedout() {
		return isCheckdedout;
	}
	public void setCheckdedout(boolean isCheckdedout) {
		this.isCheckdedout = isCheckdedout;
	}
	public Long getReservationId() {
		return reservationId;
	}
	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}
	public Discount getDiscount() {
		return discount;
	}
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "reservation_room", joinColumns = {@JoinColumn(name = "reservation_id", nullable = false) },
	inverseJoinColumns = { @JoinColumn(name = "room_id",nullable = false) })
	private List<Room> allrooms= new ArrayList<>();
	@ManyToOne
	private Branch branch;
	@OneToOne (cascade = CascadeType.ALL)
	private Customer customer;
	
	
	public Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
//	public int getNumberOfAdult() {
//		return numberOfAdult;
//	}
//	public void setNumberOfAdult(int numberOfAdult) {
//		this.numberOfAdult = numberOfAdult;
//	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public boolean isPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public List<Room> getAllrooms() {
		return allrooms;
	}
	public void setAllrooms(List<Room> allrooms) {
		this.allrooms = allrooms;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
