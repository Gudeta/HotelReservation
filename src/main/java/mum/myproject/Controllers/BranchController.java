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

import mum.myproject.Domain.Branch;
import mum.myproject.Services.BranchService;
import mum.myproject.Services.IBranchService;

@Controller
@RequestMapping(value = "/branch")
public class BranchController {
	@Autowired
	IBranchService branchservice;
	
	@Autowired
	BranchService branchService;
	
	private Long newBranchId;
	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String getForm(@ModelAttribute("newBranch") Branch branch, Model model) {
		Iterable<Branch> branches=branchservice.getAllBranch();
		List<Branch> branchlist=new ArrayList<Branch>();
		if(branches!=null){
			for(Branch b:branches){
				System.out.println(b.getBranchName());
				branchlist.add(b);
			}
		}
		
		model.addAttribute("branchlist", branchlist);	
		return "branchAddForm";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String stsave(@ModelAttribute("newBranch") @Valid Branch branchObj, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "branchAddForm";
		} else {
			if (this.branchService.findByBranchName(branchObj.getBranchName()) != null) {
				result.rejectValue("branchName", "error.branch", "The branch name should be unique.");
				return "branchAddForm";
			}
			branchservice.save(branchObj);
			return "redirect:/branch/add";
		}
	}

	@RequestMapping(value = "/edit/{branchId}", method = RequestMethod.GET)
	public String get(@PathVariable long branchId, Model model) {
		model.addAttribute("editBranch", branchservice.getBranchById(branchId));
		newBranchId=branchId;
		return "branchEditForm";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String update(Branch branch,
			@ModelAttribute("editBranch") @Valid Branch editBranch, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "branchEditForm";
		} else {
			editBranch.setBranchId(newBranchId);
			branchservice.save(editBranch);
			newBranchId=null;
			return "redirect:/branch/add";
		}
	}

	@RequestMapping(value = "/delete/{branchId}", method = RequestMethod.GET)
	public String delete(@PathVariable("branchId") Long branchId) {
		branchservice.delete(branchId);
		return "redirect:/branch/add";
	}

	@ModelAttribute("branchlist")
	public Iterable<Branch> showList() {
		Iterable<Branch> branchList = branchservice.getAllBranch();
		return branchList;
	}

}
