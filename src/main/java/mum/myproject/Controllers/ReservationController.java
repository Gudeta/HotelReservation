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
import mum.myproject.Services.IBranchService;
import mum.myproject.Services.IReservationService;
import mum.myproject.Services.IRoomService;
import mum.myproject.Services.IStaffService;

@Controller
@RequestMapping(value = "/reservation")
public class ReservationController {
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
	@RequestMapping(value= { "/showCustomerform"},params="Login", method=RequestMethod.POST)
	public String login(@ModelAttribute("newCredential") Credentials credential, Model model) {
		return "loginForm";
	}
	@RequestMapping(value= { "/showCustomerform"},params="Reserve", method=RequestMethod.POST)
	public String showuserInfo(@ModelAttribute("sbranch") @Valid Branch branchobj, BindingResult result, Model model ) {
			this.curBranch=branchservice.getBranchById(branchobj.getBranchId());
			return "redirect:/reservation/fillinfoget";
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
		return "fillinfo";
	}
	@RequestMapping(value={"/roomselection"}, method=RequestMethod.POST)
	public String showRoomForm(@ModelAttribute("customer") @Valid Customer customer, BindingResult result, Model model ) {
		if(result.hasErrors()) {
			return "fillinfo";
		} else {
			//this.curBranch=branchservice.getBranchById(branchobj.getBranchId());roomselection
			this.curCustomer=customer;
			return "redirect:/reservation/roomselection";
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
		return "roomselectionform";
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
								 room.setIsAvailable(false);
								 reservedrooms.add(room);
							 }
							 break;
						 case "King":
							 if(nok<noKing){
								 nok++;
								 reservedrooms.add(room);
								 room.setIsAvailable(false);
							 }
							 break;
						 case "Double":
							 if(nod<noDouble){
								 nod++;
								 reservedrooms.add(room);
								 room.setIsAvailable(false);
							 }
							 break;
						 default:
							 if(nos<noSingle){
								 nos++;
								 reservedrooms.add(room);
								 room.setIsAvailable(false);
							 }
								 break;
						 
						 }
					 }
						 
					 }
				 	Reservation reservationnew=new Reservation();
					reservationnew.setAllrooms(reservedrooms);
					reservationnew.setCheckInDate(checkinDate);
					reservationnew.setCheckOutDate(checkoutDate);
					reservationnew.setCustomer(curCustomer);
					reservationnew.setBranch(curBranch);
					reservationnew.setDiscount(new Discount(new PublicDiscount()));
					reservationnew.setTotalPrice(priceCalculator.calculatePrice(reservationnew));
					this.curReservatin=reservationnew;
					//reservationservice.save(reservationnew);
					return "redirect:/reservation/bill";
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
				return "roomselectionform";
			}
	}
	@RequestMapping(value="/bill", method=RequestMethod.GET)
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
		return "bill";
	}
	@RequestMapping(value={"/finish"}, method=RequestMethod.POST)
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
		return "success";
	}
	@RequestMapping(value= { "/returntohome"}, method=RequestMethod.GET)
	public String returntoMain( Model model){
		List<Reservation> allReservation=(List<Reservation>)this.reservationservice.getAllReservation();
		model.addAttribute("allreservation", allReservation);
		return "home";
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
