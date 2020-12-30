package com.proj.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.proj.dao.ConsultationRepository;
import com.proj.dao.PatientRepository;
import com.proj.entities.Consultation;
import com.proj.entities.Patient;

@Controller
public class ConsultationController {
	
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private ConsultationRepository consultationRepository;
	
	
	@RequestMapping(value="/medcin/details")
	public String indexMedcin(Model model , Long id) {
		
		Optional<Patient> p = patientRepository.findById(id);
		
		if(p.isPresent()) {
			  Patient patient = p.get();
			  model.addAttribute("patient", patient);
			  model.addAttribute("consultations" , patient.getConsultations());
		}
		
		return "details";
	}
	
	
	
	@RequestMapping(value="/medcin/formConsultation", method=RequestMethod.GET)
	public String formConsultation(Model model) {
		model.addAttribute("consultation", new Consultation());
		
		return "formConsultation";
	}
	
	
	@RequestMapping(value="/medcin/saveConsultation", method=RequestMethod.POST)
	public String saveMedcin(Model model, @Valid Consultation consultation, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "formConsultation";
		}
		
		consultationRepository.save(consultation);
		return "confirmationConsultation";
	}
	
	
}
