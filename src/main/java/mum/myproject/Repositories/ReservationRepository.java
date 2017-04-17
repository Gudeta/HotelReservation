package mum.myproject.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.myproject.Domain.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long>{

}
