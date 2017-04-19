package mum.myproject.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mum.myproject.Domain.Branch;
import mum.myproject.Domain.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long>{
	
	@Query("select r from Reservation r where branch=:branchId")
	public List<Reservation> findReserevationByBranch(@Param("branchId")Branch branch);

}
