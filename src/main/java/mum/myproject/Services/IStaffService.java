package mum.myproject.Services;

import mum.myproject.Domain.Staff;

public interface IStaffService {
	public void save(Staff staffObj);

	public Staff getStaffById(long id);

	public void delete(Long id);

	public Iterable<Staff> getAllStaff();
	
	public Staff findByStaffId(long number);
}
