package mum.myproject.Domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@NamedQuery(name = "Branch.findAllInDescendingOrder", query="select b from Branch b order by branchId desc ")
public class Branch {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long branchId;

	@Column(unique = true)
	@Size(min=2, max=30)
	@NotEmpty(message="no empty field accepted")
	private String branchName;

	@Embedded
	private Location location;
	
		public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

		public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
}
