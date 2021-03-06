package mum.myproject.Services;


import mum.myproject.Domain.Branch;

public interface IBranchService {
	public void save(Branch branchObj);

	public Branch getBranchById(long id);
	public void editBranch(Branch branch);
	public boolean delete(Long id);

	public Iterable<Branch> getAllBranch();
	
	public Branch findByBranchName(String name);

	public Iterable<Branch> findAllInDescendingOrder();
}
