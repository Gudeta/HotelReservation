package mum.myproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.myproject.Domain.Branch;
import mum.myproject.Repositories.BranchRepository;
import mum.myproject.Repositories.ReservationRepository;
import mum.myproject.Services.IBranchService;

@Service
@Transactional
public class BranchService implements IBranchService {
	@Autowired
	BranchRepository branchRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	
	
	@Override
	public void save(Branch branchObj) {
		
		branchRepository.save(branchObj);
	}

	@Override
	public Branch getBranchById(long id) {
		return this.branchRepository.findOne(id);
	}

	@Override
	public boolean delete(Long id) {
		//check the validity of the deletion
		
		Branch branch=branchRepository.findOne(id);
		if(reservationRepository.findReserevationByBranch(branch).size()>0){
			return false;
		}
		this.branchRepository.delete(id);
		return true;
		
	}

	@Override
	public Iterable<Branch> getAllBranch() {
		return this.branchRepository.findAll();
	}

	@Override
	public Branch findByBranchName(String name) {
		//return this.branchRepository.findBranchByName(name);
		return null;
	}

	@Override
	public void editBranch(Branch branch) {
		Long id=branch.getBranchId();
		Branch fromDataBase=branchRepository.findOne(id);
		
		
	}

	@Override
	public Iterable<Branch> findAllInDescendingOrder() {

		return branchRepository.findAllInDescendingOrder();
	}
	
	

}
