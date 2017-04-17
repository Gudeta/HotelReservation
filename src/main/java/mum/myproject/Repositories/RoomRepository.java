package mum.myproject.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.myproject.Domain.Room;
@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{

}
