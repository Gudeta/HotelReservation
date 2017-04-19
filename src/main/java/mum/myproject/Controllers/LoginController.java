package mum.myproject.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.myproject.Domain.Branch;
import mum.myproject.Domain.Credentials;
import mum.myproject.Domain.Reservation;
import mum.myproject.Domain.RoomDummy;
import mum.myproject.Domain.Staff;
import mum.myproject.Services.IBranchService;
import mum.myproject.Services.IReservationService;
import mum.myproject.Services.IStaffService;

@Controller
public class LoginController {
	@Autowired
	IStaffService staffservice;
	@Autowired
	IBranchService branchService;
	@Autowired
	IReservationService reservationService;
	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String home(@ModelAttribute("sbranch") Branch branch, Model model) {
		Iterable<Branch> branches = branchService.getAllBranch();
		List<Branch> branchlist = new ArrayList<Branch>();
		if (branches != null) {
			for (Branch b : branches) {
				System.out.println(b.getBranchName());
				branchlist.add(b);
			}
		}
		model.addAttribute("branchList", branchlist);
		return "home";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(@ModelAttribute("newCredential") Credentials credential, Model model) {
		return "loginForm";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String loginPost(@ModelAttribute("newCredential") @Valid Credentials credential, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "loginForm";
		} else {
			Iterable<Staff> all_staff = staffservice.getAllStaff();
			boolean found = false;
			boolean isStaff = true;
			String username = credential.getUsername().trim();
			String password = credential.getPassword().trim();
			for (Staff staff : all_staff) {
				if ((staff.getStaffPassword().trim().equals(password))
						&& (staff.getStaffUserName().trim().equals(username))) {
					if (staff.getRole().equalsIgnoreCase("Admin")) {
						isStaff = false;
					}
					System.out.println("found");
					found = true;
					break;
				}
			}
			if (!found) {
				 result.rejectValue("password", "password.branch", "Password username mismatch.");
				return "loginForm";
			}
			if (isStaff) {
				List<Reservation> allReservation = (List<Reservation>) reservationService.getAllReservation();
				model.addAttribute("allreservation", allReservation);
				return "staff";
			}
			System.out.println("redirecting....");
			return "admin";
		}
	}

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String goHome(Model model) {
		return "home";
	}
}
