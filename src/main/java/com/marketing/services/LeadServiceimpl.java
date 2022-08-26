package com.marketing.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//stereotype means this class is managed by spring boot
import com.marketing.entities.Lead;
import com.marketing.repositories.LeadRepository;
@Service //@Service is use to tell this is not an ordinary class, this is spring class
//spring boot knows that this is not an ordinary layer,this is service layer,which is -
//responsible to interact with repository layer so
//how we interact with repository layer ,answer is - @Autowired
public class LeadServiceimpl implements LeadService {
//Q- Where did you use inheritance n polymorphism ??, while creating service layer
	@Autowired
	private LeadRepository leadRepo;
	@Override
	public void saveLead(Lead lead) {
		leadRepo.save(lead);
		}
	@Override
	public List<Lead> listLead() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}
	@Override
	public void deleteLeadById(long id) {
		leadRepo.deleteById(id);
		
	
	}
	@Override
	public Lead getOneLead(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}
}
