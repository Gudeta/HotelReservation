package mum.myproject.Repositories;

import org.springframework.data.repository.CrudRepository;

import mum.myproject.Domain.Staff;

public interface StaffRepository extends CrudRepository<Staff, Long>{

	//public Staff findStaffByName(); 

}
