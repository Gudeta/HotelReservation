package mum.myproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.myproject.Domain.Staff;
import mum.myproject.Repositories.StaffRepository;

@Transactional
@Service

public class StaffService implements IStaffService{
	@Autowired
	StaffRepository staffRepository;
	@Override
	public void save(Staff staffObj) {
		staffRepository.save(staffObj);
	}

	@Override
	public Staff getStaffById(long id) {
		return this.staffRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		this.staffRepository.delete(id);		
	}

	@Override
	public Iterable<Staff> getAllStaff() {
		return this.staffRepository.findAll();
	}

	@Override
	public Staff findByStaffId(long number) {
		return this.staffRepository.findOne(number);
	}

}
