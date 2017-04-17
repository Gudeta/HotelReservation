package mum.myproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.myproject.Domain.Reservation;
import mum.myproject.Repositories.ReservationRepository;
import mum.myproject.Services.IReservationService;

@Service
@Transactional
public class ReservationService implements IReservationService{
@Autowired
ReservationRepository reservationRepository;

@Override
public void save(Reservation reservationObj) {
	reservationRepository.save(reservationObj);
}

@Override
public Reservation getReservationById(long id) {
	return this.reservationRepository.findOne(id);
}

@Override
public void delete(Long id) {
	this.reservationRepository.delete(id);
}

@Override
public Iterable<Reservation> getAllReservation() {
	return this.reservationRepository.findAll();
}

@Override
public void checkoutReservation(Reservation reservation) {
	reservation.setCheckdedout(true);
	this.reservationRepository.save(reservation);
}
}
