package mum.myproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.myproject.Domain.Room;
import mum.myproject.Repositories.RoomRepository;
import mum.myproject.Services.IRoomService;
@Transactional
@Service
public  class RoomService implements IRoomService{
@Autowired
	RoomRepository roomRepository;
	@Override
	public void save(Room roomObj) {
		roomRepository.save(roomObj);
	}

	@Override
	public Room getRoomById(Long id) {
		return this.roomRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		this.roomRepository.delete(id);
	}

	@Override
	public Iterable<Room> getAllRoom() {
		return this.roomRepository.findAll();
	}

	@Override
	public Room findByRoomId(Long number) {
		return this.roomRepository.findOne(number);
	}

	@Override
	public Room findByRoomNumber(String number) {
		Iterable<Room> allrooms=getAllRoom();
		for(Room room:allrooms){
			if(room.getRoomNumber().equals(number)) {
				return room;
			}
		}
		return null;
	}

	//@Override
	//public Room findByRoomNumber(String number) {
	//	return null;
	//}

}
