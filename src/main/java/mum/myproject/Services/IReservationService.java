package mum.myproject.Services;

import mum.myproject.Domain.Reservation;

public interface IReservationService {
	public void save(Reservation branchObj);

	public Reservation getReservationById(long id);

	public void delete(Long id);

	public Iterable<Reservation> getAllReservation();
	public void checkoutReservation(Reservation reservation);
	//public Reservation findByReservationId(Long id);

//	public void createReservation(Reservation reservationObj);
}
