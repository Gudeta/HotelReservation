package mum.myproject.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.myproject.Domain.Branch;

@Repository
public interface BranchRepository extends CrudRepository<Branch, Long> {
	//Branch findBranchByName(String name);
	
}
