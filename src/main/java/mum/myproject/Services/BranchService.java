package mum.myproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.myproject.Domain.Branch;
import mum.myproject.Repositories.BranchRepository;
import mum.myproject.Services.IBranchService;

@Service
@Transactional
public class BranchService implements IBranchService {
	@Autowired
	BranchRepository branchRepository;
	
	@Override
	public void save(Branch branchObj) {
		
		branchRepository.save(branchObj);
	}

	@Override
	public Branch getBranchById(long id) {
		return this.branchRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		this.branchRepository.delete(id);
		
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

}
