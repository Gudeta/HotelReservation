package mum.myproject.Domain;

public class RoomDummy {
	private String roomNumber;
	private String roomtypeName;
	private double roomtypeprice;
	private Long branchId;
	public Long getBranchId() {
		return branchId;
	}
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}
	public Room gateRoom(){
		Room r =new Room();
		r.setRoomNumber(roomNumber);
		if(roomtypeName.equalsIgnoreCase("King"))r.setRoomtype(Roomtype.KING);
		else if(roomtypeName.equalsIgnoreCase("Queen"))r.setRoomtype(Roomtype.QUEEN);
		else if(roomtypeName.equalsIgnoreCase("Double"))r.setRoomtype(Roomtype.DOUBLE);
		else r.setRoomtype(Roomtype.SINGLE);
		return r;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
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
