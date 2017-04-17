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
import mum.myproject.Domain.Room;
import mum.myproject.Domain.RoomDummy;
import mum.myproject.Services.IBranchService;
import mum.myproject.Services.IRoomService;

@Controller
@RequestMapping(value ="/room")
public class RoomController {
	@Autowired
	IRoomService roomservice;
	@Autowired
	IBranchService branchservice;
	Long curentRoomID=null;
	@RequestMapping(value={"/add"},method=RequestMethod.GET)
	public String getForm(@ModelAttribute("newRoom") RoomDummy room,Model model){
		List<Branch> branches=new ArrayList<>();
		for(Branch branch:branchservice.getAllBranch()){
			branches.add(branch);
		}
		model.addAttribute("roomLists", roomservice.getAllRoom());
		model.addAttribute("branchList", branches);
		return "roomAddForm";
	}

	@RequestMapping(value={"/add"},method=RequestMethod.POST) 
	public String stsave(@ModelAttribute("newRoom") @Valid RoomDummy roomObj, BindingResult result,Model model){
		if(result.hasErrors()){
			return "roomAddForm";
		}else{
			if (this.roomservice.findByRoomNumber(roomObj.getRoomNumber()) != null) {
				result.rejectValue("roomNumber", "error.room", "The room number should be unique.");
				model.addAttribute("roomLists", roomservice.getAllRoom());
				List<Branch> branches=new ArrayList<>();
				for(Branch branch:branchservice.getAllBranch()){
					branches.add(branch);
				}
				model.addAttribute("branchList", branches);
				return "roomAddForm";
			}
			/*else if (this.roomservice.findByRoomNumber(roomObj.getRoomNumber()) != null) {
				result.rejectValue("roomNumber", "error.room", "The room number should be unique.");
				return "roomAddForm";
			}*/
			Room room=roomObj.gateRoom();
			Long branchId=roomObj.getBranchId();
			Branch branch=branchservice.getBranchById(branchId);
			room.setBranch(branch);
			room.setIsAvailable(true);
			roomservice.save(room);
			return "redirect:/room/add";
		}
	}

	@RequestMapping(value="/edit/{roomId}", method=RequestMethod.GET)
	public String get(@PathVariable Long roomId, Model model) {
		model.addAttribute("editRoom", new RoomDummy());
		model.addAttribute("oldRoom", roomservice.findByRoomId(roomId));
		curentRoomID=roomId;
		return "roomEditForm";
	}

	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String update(Room room,  @ModelAttribute("editRoom") @Valid RoomDummy editRoom, BindingResult result, Model model) {
		if(result.hasErrors()){
			return"roomEditForm";
		}else{
			Room tobeEditted=editRoom.gateRoom();
			room.setId(curentRoomID);
			roomservice.save(tobeEditted);
			curentRoomID=null;
			return "redirect:/room/add";
		}
	}

	@RequestMapping(value="/delete/{roomId}", method=RequestMethod.GET)
	public String delete(@PathVariable("roomId") Long roomId) {
		roomservice.delete(roomId);
		return "redirect:/room/add";
	}

	@ModelAttribute("roomlist")
		public Iterable<Room> showList(){
		Iterable<Room> roomList= roomservice.getAllRoom();
		return roomList;
	}
}
