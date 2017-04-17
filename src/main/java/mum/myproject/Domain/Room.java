package mum.myproject.Domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Room {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotEmpty(message="No empty field accepted !")
	private String roomNumber;
	@ManyToOne
	private Branch branch;
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "allrooms")
	private List<Reservation> allReservations=new ArrayList<>();
	/*@ManyToMany 
	@Cascade(org.hibernate.annotations.CascadeType.ALL)*/
	private Boolean isAvailable=true;
	public List<Reservation> getAllReservations() {
		return allReservations;
	}
	public void setAllReservations(List<Reservation> allReservations) {
		this.allReservations = allReservations;
	}
	public Branch getBranch() {
		return branch;
	}
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	private Roomtype roomtype;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Roomtype getRoomtype() {
		return roomtype;
		}
	public void setRoomtype(Roomtype roomtype) {
		this.roomtype = roomtype;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
}
