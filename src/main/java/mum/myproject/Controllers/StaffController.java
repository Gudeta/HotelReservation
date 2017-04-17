package mum.myproject.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.myproject.Domain.Staff;
import mum.myproject.Services.IStaffService;
import mum.myproject.Services.StaffService;

@Controller
@RequestMapping(value = "/staff")
public class StaffController {
	@Autowired
	IStaffService staffservice;
	
	@Autowired
	StaffService staffService;
	
	private Long newStaffId;

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String getForm(@ModelAttribute("newStaff") Staff staff, Model model) {
		Iterable<Staff> staffes=staffservice.getAllStaff();
		List<Staff> stafflist=new ArrayList<Staff>();
		if(staffes!=null){
			for(Staff b:staffes){
				System.out.println(b.getStaffFirstName());
				stafflist.add(b);
			}
		}
		
		model.addAttribute("stafflist", stafflist);
		return "staffAddForm";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String stsave(@ModelAttribute("newStaff") @Valid Staff staffObj, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "staffAddForm";
		}
			staffservice.save(staffObj);
			return "redirect:/staff/add";
	}

	@RequestMapping(value = "/edit/{staffId}", method = RequestMethod.GET)
	public String get(@PathVariable long staffId, Model model) {
		model.addAttribute("editStaff", staffservice.getStaffById(staffId));
		return "staffEditForm";
	}

	@RequestMapping(value = "/edit/{staffId}", method = RequestMethod.POST)
	public String update(Staff staff, @PathVariable long staffId,
			@ModelAttribute("editStaff") @Valid Staff editStaff, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "staffEditForm";
		} else {
			editStaff.setStaffId(newStaffId);
			staffservice.save(editStaff);
			newStaffId=null;
			return "redirect:/staff/add";
		}
	}
	/*@RequestMapping(value = "/edit/{staffId}", method = RequestMethod.POST)
	public String update(Staff staff, @PathVariable long staffId,
			@ModelAttribute("editStaff") @Valid Staff editStaff, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "staffEditForm";
		} else {
			if (this.staffservice.findByName(staffObj.getStaffName()) != null) {
				result.rejectValue("staffSsn", "error.staff", "The staff SSN should be unique.");
				return "staffAddForm";
			}
			staff.setStaffId(staffId);
			staffservice.save(editStaff);
			return "redirect:/staff/add";
		}
	}*/

	@RequestMapping(value = "/delete/{staffId}", method = RequestMethod.GET)
	public String delete(@PathVariable("staffId") Long staffId) {
		staffservice.delete(staffId);
		return "redirect:/staff/add";
	}

	@ModelAttribute("stafflist")
	public Iterable<Staff> showList() {
		Iterable<Staff> staffList = staffservice.getAllStaff();
		return staffList;
	}
}
