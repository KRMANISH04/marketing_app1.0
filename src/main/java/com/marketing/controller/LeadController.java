package com.marketing.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.LeadData;
import com.marketing.entities.Lead;
import com.marketing.services.LeadService;
//in order to apply controller layer on java class use annotation @Controller
//NOW THIS CAN INTERACT WITH view 
@Controller
public class LeadController {
//to call the services layer
//create the ref. variable of interface by writing leadService
@Autowired//it will automatically creates the object of leadServiceimpl and inject
//the address into it,but only when this annotation (@Autowired)is applied
	public LeadService leadService;
	//so we don't create here obj .by typing new keyword, so write @Autowired
	@RequestMapping("/createLead")//instead of @ webservlet
	public String viewCreateLeadPage() {
		return "create_lead";//act as a request dispatcher
		}
	@RequestMapping("/saveLead")
	public String saveOneLead(@ModelAttribute("lead") Lead lead,ModelMap model) {
		leadService.saveLead(lead);
		model.addAttribute("msg", "Lead is saved !!");
		return "create_lead";
	}
		//Lead is entity class
//@ModelAttribute ,it automatically takes the data from form,then creates a Lead object 
//and store that data into Lead obj.and that lead obj. address is in *lead		
// so Lead is class name and lead is ref.variable		
//		System.out.println(lead.getFirstName());
//		System.out.println(lead.getLastName());
//		System.out.println(lead.getEmail());
//		System.out.println(lead.getMobile());
		//leadService.saveLead(lead);
		//return "create_lead";
	//}
//@RequestMapping("/saveLead")
//public String saveOneLead(@RequestParam("name") String fname,@RequestParam("lastname")String lName,@RequestParam("emailId")String email,@RequestParam("mobileNumber")Long mobile) {
 //it is  lengthy when we more more attributes, so we use #DTO

//	to print in console as backend	
		//System.out.println(fname);
//		System.out.println(lName);
//		System.out.println(email);
//		System.out.println(mobile);
		
// to save in data base
//		Lead l= new Lead();
//		l.setFirstName(lName);
//		l.setLastName(lName);
//		l.setEmail(email);
//		l.setMobile(mobile);
//		leadService.saveLead(l);
//		
//		return "create_lead";
//		}
	
 //DTO DATE TRANSFER OBJECT
	//@RequestMapping("/saveLead")
		//public String saveOneLead(LeadData data,ModelMap model) {
//		System.out.println(data.getFirstName());
//		System.out.println(data.getLastName());
//		System.out.println(data.getEmail());
//		System.out.println(data.getMobile());
		// let save the data in database,to save the data we need lead obj
//		Lead lead = new Lead();
//		lead.setFirstName(data.getFirstName());
//		lead.setLastName(data.getLastName());
//		lead.setEmail(data.getEmail());
//		lead.setMobile(data.getMobile());
		//leadService.saveLead(lead);
		//System.out.println("DONE");
			//model.addAttribute("msg", "Lead is saved !!");
	        //return "create_lead";
	
	
	//-----lecture on jstl 22/07/2022
	
	
	@RequestMapping("/listAll")
	public String listAllLeads(ModelMap model) {
		List<Lead> leads= leadService.listLead();
		model.addAttribute("leads", leads);
	
		return "lead_search_result";
	}
	@RequestMapping("/delete")
	public String deleteOneLead(@RequestParam("id") long id,ModelMap model) {
		leadService.deleteLeadById(id);
		List<Lead> leads= leadService.listLead();
		model.addAttribute("leads", leads);
	    return "lead_search_result";
		
	}
	@RequestMapping("/update")
	public String updateOneLead(@RequestParam("id")long id,ModelMap model) {
		Lead lead = leadService.getOneLead(id);
		model.addAttribute("lead", lead);
		return "update_lead";
		
	}
	@RequestMapping("/updateLead")
	public String updateOneLeadData(LeadData data,ModelMap model) {
		Lead lead = new Lead();
		lead.setId(data.getId());
		lead.setFirstName(data.getFirstName());
		lead.setLastName(data.getLastName());
		lead.setEmail(data.getEmail());
		lead.setMobile(data.getMobile());
		leadService.saveLead(lead);
		List<Lead> leads= leadService.listLead();
		model.addAttribute("leads", leads);
	    return "lead_search_result";
		
	}
}
	

