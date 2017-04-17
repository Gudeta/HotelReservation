package mum.myproject.Services;

import mum.myproject.Domain.Room;

public interface IRoomService {
	public void save(Room roomObj);

	public Room getRoomById(Long id);

	public void delete(Long id);

	public Iterable<Room> getAllRoom();
	
	public Room findByRoomId(Long number);

	//check this one out.....
	public Room findByRoomNumber(String number);
}
