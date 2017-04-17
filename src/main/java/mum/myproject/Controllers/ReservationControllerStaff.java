package mum.myproject.Controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.myproject.Domain.Branch;
import mum.myproject.Domain.Credentials;
import mum.myproject.Domain.Customer;
import mum.myproject.Domain.Discount;
import mum.myproject.Domain.PublicDiscount;
import mum.myproject.Domain.Reservation;
import mum.myproject.Domain.ReservationDummy;
import mum.myproject.Domain.Room;
import mum.myproject.Domain.Roomtype;
import mum.myproject.Domain.StaffDiscount;
import mum.myproject.Domain.VeteranDiscount;
import mum.myproject.Services.IBranchService;
import mum.myproject.Services.IReservationService;
import mum.myproject.Services.IRoomService;
import mum.myproject.Services.IStaffService;

@Controller
@RequestMapping(value = "/reservationstaff")
public class ReservationControllerStaff {
	@Autowired
	private MailSender emailSender; 
	@Autowired
	PriceCalculator priceCalculator;
	@Autowired
	IReservationService reservationservice;
	
	@Autowired
	IBranchService branchservice;
	
	@Autowired
	IStaffService staffservice;
	
	@Autowired
	IRoomService roomservice;
	Branch curBranch;
	Customer curCustomer;
	Reservation curReservatin;
	/*@RequestMapping(value= { "/start"},method=RequestMethod.GET)
	public String begin(@ModelAttribute("newCredential") Credentials credential, Model model) {
		return "homestaff";
	}*/
	@RequestMapping(value= { "/start"},method=RequestMethod.GET)
	public String home(@ModelAttribute("sbranch") Branch branch, Model model) {	
		Iterable<Branch> branches=branchservice.getAllBranch();
		List<Branch> branchlist=new ArrayList<Branch>();
		if(branches!=null){
			for(Branch b:branches){
				System.out.println(b.getBranchName());
				branchlist.add(b);
			}
		}
		
		model.addAttribute("branchList", branchlist);
		return "homestaff";
	}
	@RequestMapping(value= { "/showCustomerform"},params="Login", method=RequestMethod.POST)
	public String login(@ModelAttribute("newCredential") Credentials credential, Model model) {
		return "loginForm";
	}
	@RequestMapping(value= { "/showCustomerform"},params="Reserve", method=RequestMethod.POST)
	public String showuserInfo(@ModelAttribute("sbranch") @Valid Branch branchobj, BindingResult result, Model model ) {
			this.curBranch=branchservice.getBranchById(branchobj.getBranchId());
			return "redirect:/reservationstaff/fillinfoget";
	}
	/*@RequestMapping(value={"/showcusform"}, method=RequestMethod.POST)
	public String showcusform(@ModelAttribute("sbranch") @Valid Branch branchobj, BindingResult result, Model model ) {
		if(result.hasErrors()) {
			return "";
		} else {
			//reservationservice.createReservation(reservationObj);
			//reservationservice.save(branchobj);
			return "redirect:/reservation/add";
		}
	}*/
	@RequestMapping(value = { "/fillinfoget" }, method = RequestMethod.GET)
	public String showRoomFormGet(@ModelAttribute("customer") Customer customer, Model model) {		
		return "fillinfostaffs";
	}
	@RequestMapping(value={"/roomselection"}, method=RequestMethod.POST)
	public String showRoomForm(@ModelAttribute("customer") @Valid Customer customer, BindingResult result, Model model ) {
		if(result.hasErrors()) {
			return "fillinfostaffs";
		} else {
			//this.curBranch=branchservice.getBranchById(branchobj.getBranchId());roomselection
			this.curCustomer=customer;
			return "redirect:/reservationstaff/roomselection";
		}
	}
	@RequestMapping(value = { "/roomselection" }, method = RequestMethod.GET)
	public String roomSelectionGet(@ModelAttribute("reservation") ReservationDummy reservation, Model model) {	
		Iterable<Room> allroom=roomservice.getAllRoom();
		int noqueen=0;int noking=0;int nodouble=0;int nosingle=0;
		for(Room room : allroom){
			if(room.getIsAvailable()){
				System.out.println(room.getRoomtype().getRoomtypeName());
				if(room.getRoomtype().getRoomtypeName().equals(Roomtype.QUEEN.getRoomtypeName()))noqueen++;
				if(room.getRoomtype().getRoomtypeName().equals(Roomtype.KING.getRoomtypeName()))noking++;
				if(room.getRoomtype().getRoomtypeName().equals(Roomtype.DOUBLE.getRoomtypeName()))nodouble++;
				if(room.getRoomtype().getRoomtypeName().equals(Roomtype.SINGLE.getRoomtypeName()))nosingle++;
			}
			List<Integer> queens=new ArrayList<Integer>();
			List<Integer> kings=new ArrayList<Integer>();
			List<Integer> doubles=new ArrayList<Integer>();
			List<Integer> singles=new ArrayList<Integer>();
			for(int i=0;i<=noqueen;i++)queens.add(i);
			for(int i=0;i<=noking;i++)kings.add(i);
			for(int i=0;i<=nodouble;i++)doubles.add(i);
			for(int i=0;i<=nosingle;i++)singles.add(i);
			model.addAttribute("queenlist", queens);
			model.addAttribute("kinglist", kings);
			model.addAttribute("singlelist", singles);
			model.addAttribute("doublelist", doubles);
			
		}
		return "roomselectionformstaff";
	}
	/*@RequestMapping(value={"/save"},method=RequestMethod.GET)
	public String getForm(@ModelAttribute("newReservation")Reservation reservation, Model model) {
		model.addAttribute("roomList", roomservice.getAllRoom());
		return "reservationAddForm";
	}*/

	@RequestMapping(value={"/save"}, method=RequestMethod.POST)
	public String generateReservation(@ModelAttribute("reservation")  ReservationDummy reservationObj,  Model model ) {		
			try{
				System.out.println(reservationObj.getCheckInDate());
				System.out.println(reservationObj.getCheckOutDate());
				 DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
				 List<Room> reservedrooms=new ArrayList<>();
				 Date checkinDate =  df.parse(reservationObj.getCheckInDate()); 
				 Date checkoutDate=df.parse(reservationObj.getCheckOutDate());
				 if(checkoutDate.before(checkinDate))throw new Exception();
				 System.out.println(new Date());
				 //if(checkinDate.before(new Date()))throw new Exception();
				 int noQueen=reservationObj.getNumberQueen();
				 int noKing=reservationObj.getNumberKing();
				 int noDouble=reservationObj.getNumberDouble();
				 int noSingle=reservationObj.getNumberSingle();
				 if(noQueen+noKing+noDouble+noSingle ==0)throw new Exception();
				 int noq=0,nod=0,nok=0,nos=0;
				 Iterable<Room> allroom=roomservice.getAllRoom();
				 for(Room room:allroom){
					 if(room.getIsAvailable()){
						 switch(room.getRoomtype().getRoomtypeName()){
						 case "Queen":
							 if(noq<noQueen){
								 noq++;
								 //room.setIsAvailable(false);
								 reservedrooms.add(room);
							 }
							 break;
						 case "King":
							 if(nok<noKing){
								 nok++;
								 reservedrooms.add(room);
								 //room.setIsAvailable(false);
							 }
							 break;
						 case "Double":
							 if(nod<noDouble){
								 nod++;
								 reservedrooms.add(room);
								 //room.setIsAvailable(false);
							 }
							 break;
						 default:
							 if(nos<noSingle){
								 nos++;
								 reservedrooms.add(room);
								// room.setIsAvailable(false);
							 }
								 break;
						 
						 }
					 }
						 
					 }
				 Reservation reservationnew=new Reservation();
				 if(reservationObj.getDiscountType().equalsIgnoreCase("Public")){reservationnew.setDiscount(new Discount(new PublicDiscount()));};
				 if(reservationObj.getDiscountType().equalsIgnoreCase("Veteran")){reservationnew.setDiscount(new Discount(new VeteranDiscount()));};
				 if(reservationObj.getDiscountType().equalsIgnoreCase("Staff")){reservationnew.setDiscount(new Discount(new StaffDiscount()));};
				 	
					reservationnew.setAllrooms(reservedrooms);
					reservationnew.setCheckInDate(checkinDate);
					reservationnew.setCheckOutDate(checkoutDate);
					reservationnew.setCustomer(curCustomer);
					reservationnew.setBranch(curBranch);
					reservationnew.setTotalPrice(priceCalculator.calculatePrice(reservationnew));
					curReservatin=reservationnew;
					//reservationservice.save(reservationnew);
					return "redirect:/reservationstaff/staffbill";
			}
			catch(Exception e){
				e.printStackTrace();
				Iterable<Room> allroom=roomservice.getAllRoom();
				int noqueen=0;int noking=0;int nodouble=0;int nosingle=0;
				for(Room room : allroom){
					if(room.getIsAvailable()){
						System.out.println(room.getRoomtype().getRoomtypeName());
						if(room.getRoomtype().getRoomtypeName().equals(Roomtype.QUEEN.getRoomtypeName()))noqueen++;
						if(room.getRoomtype().getRoomtypeName().equals(Roomtype.KING.getRoomtypeName()))noking++;
						if(room.getRoomtype().getRoomtypeName().equals(Roomtype.DOUBLE.getRoomtypeName()))nodouble++;
						if(room.getRoomtype().getRoomtypeName().equals(Roomtype.SINGLE.getRoomtypeName()))nosingle++;
					}
					List<Integer> queens=new ArrayList<Integer>();
					List<Integer> kings=new ArrayList<Integer>();
					List<Integer> doubles=new ArrayList<Integer>();
					List<Integer> singles=new ArrayList<Integer>();
					for(int i=0;i<=noqueen;i++)queens.add(i);
					for(int i=0;i<=noking;i++)kings.add(i);
					for(int i=0;i<=nodouble;i++)doubles.add(i);
					for(int i=0;i<=nosingle;i++)singles.add(i);
					model.addAttribute("queenlist", queens);
					model.addAttribute("kinglist", kings);
					model.addAttribute("singlelist", singles);
					model.addAttribute("doublelist", doubles);
					
				}
				return "roomselectionformstaff";
			}
	}
	@RequestMapping(value="/staffbill", method=RequestMethod.GET)
	public String billget(Model model) {
		List<String> info=new ArrayList<>();
		info.add("Customer Name: "+this.curReservatin.getCustomer().getfName()+" "+this.curReservatin.getCustomer().getlName());
		info.add("Checkin Date: "+this.curReservatin.getCheckInDate().toString());
		info.add("Checkout Date: "+this.curReservatin.getCheckOutDate().toString());
		info.add("\n");
		info.add("Room List: ");
		for(Room room:curReservatin.getAllrooms()){
			info.add(room.getRoomtype().getRoomtypeName()+"+  $ "+room.getRoomtype().getRoomtypeprice());
		}
		info.add("\n");
		info.add("Total Price: "+this.curReservatin.getTotalPrice());
		model.addAttribute("listinfo", info);
		return "staffbill";
	}
	@RequestMapping(value={"/finishstaff"}, method=RequestMethod.POST)
	public String finish(){
		for(Room room:this.curReservatin.getAllrooms()){
			room.setIsAvailable(false);
			this.roomservice.save(room);
		}
		SimpleMailMessage emailMessage = new SimpleMailMessage();
		emailMessage.setFrom("gudetabesso@gmail.com");
		emailMessage.setTo(this.curCustomer.getEmail());
		emailMessage.setSubject("Reservation@Maharishi Hotel");
		String message="";
		message+="\nCustomer Name: "+this.curReservatin.getCustomer().getfName()+" "+this.curReservatin.getCustomer().getlName();
		message+="\nCheckin Date: "+this.curReservatin.getCheckInDate().toString();
		message+="\nCheckout Date: "+this.curReservatin.getCheckOutDate().toString();
		message+="\n";
		message+="Room List: ";
		for(Room room:curReservatin.getAllrooms()){
			message+="\n"+room.getRoomtype().getRoomtypeName()+"+  $ "+room.getRoomtype().getRoomtypeprice();
		}
		message+="\n";
		message+="Total Price: "+this.curReservatin.getTotalPrice();
		emailMessage.setText(message);
		this.emailSender.send(emailMessage);
		this.curReservatin.setCheckdedout(false);
		reservationservice.save(this.curReservatin);
		return "successstaff";
	}
	@RequestMapping(value="/checkout/{id}", method=RequestMethod.GET)
	public String checkout(@PathVariable("id") Long id, Model model) {
		Reservation reservation=reservationservice.getReservationById(id);
		for(Room room: reservation.getAllrooms()){
			room.setIsAvailable(true);
			roomservice.save(room);
		}
		this.reservationservice.checkoutReservation(reservation);
		List<Reservation> allReservation=new ArrayList<>();
		List<Reservation> temp=(List<Reservation>)reservationservice.getAllReservation();
		for(Reservation res: temp){
			if(!res.isCheckdedout())allReservation.add(res);
		}
		model.addAttribute("allreservation", allReservation);
		return "staff";
	}
	@RequestMapping(value= { "/returntomain"}, method=RequestMethod.GET)
	public String returntoMain( Model model){
		List<Reservation> allReservation=new ArrayList<>();
		List<Reservation> temp=(List<Reservation>)reservationservice.getAllReservation();
		for(Reservation res: temp){
			if(!res.isCheckdedout())allReservation.add(res);
		}
		model.addAttribute("allreservation", allReservation);
		return "staff";
	}
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		reservationservice.delete(id);
		return "redirect:/reservation/add";
	}

	@RequestMapping(value="/view/{id}", method=RequestMethod.GET)
	public String viewReservation(@PathVariable("id") Long reservationId, Model model) {
		model.addAttribute("reservation", reservationservice.getReservationById(reservationId));
		return "viewReservation";
	}

	@ModelAttribute("reservationList")
	public List<Reservation> showList(){
		List<Reservation> reservationList =new ArrayList<>() ;//=reservationservice.getAllReservation();
		return reservationList;
	}
}
