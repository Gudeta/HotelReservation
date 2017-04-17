package mum.myproject.Domain;

public enum Roomtype {
	
	SINGLE("SINGLE",40.0), DOUBLE("Double",60.0),QUEEN("Queen",90),KING("King",100.0);
	private int id;
	private String roomtypeName;
	private double roomtypeprice;
	Roomtype(String roomtypeName, double roomtypeprice){
		this.roomtypeName=roomtypeName;
		this.roomtypeprice=roomtypeprice;
	}
	Roomtype(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoomtypeName() {
		return roomtypeName;
	}
	public void setRoomtypeName(String roomtypeName) {
		this.roomtypeName = roomtypeName;
	}
	public double getRoomtypeprice() {
		return roomtypeprice;
	}
	public void setRoomtypeprice(double roomtypeprice) {
		this.roomtypeprice = roomtypeprice;
	}

}
