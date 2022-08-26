package com.marketing.services;

import java.util.List;

import com.marketing.entities.Lead;



public interface LeadService {
	public void saveLead(Lead lead); // here is abstraction concept, 
	//where i define a-
//- incomplete method and achieve abstraction
//Q- where you used encapsulation?? ,
	//while developing entity classes in my project,i have used encapsulation

	public List<Lead> listLead();

	public void deleteLeadById(long id);

	public Lead getOneLead(long id);



	
	
	
}
