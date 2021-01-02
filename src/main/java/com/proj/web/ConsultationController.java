package com.proj.web;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proj.dao.ConsultationRepository;
import com.proj.dao.PatientRepository;
import com.proj.dao.MedcinRepository;
import com.proj.entities.Consultation;
import com.proj.entities.Medcin;
import com.proj.entities.Patient;


@Controller
public class ConsultationController {
	
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private MedcinRepository medcinRepository;
	
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
	public String formConsultation(Model model, Long id) {
        
		Optional<Patient> p = patientRepository.findById(id);
		
		if(p.isPresent()) {
			Patient patient = p.get();
			model.addAttribute("patient", patient.getId());
			model.addAttribute("consultation", new Consultation());
		}
		
		return "formConsultation";
	}
	
	
	@RequestMapping(value="/medcin/saveConsultation", method=RequestMethod.POST)
	public String saveConsultation(Model model, @Valid Consultation consultation, BindingResult bindingResult,HttpServletRequest request, 
									Long id){
		
		if(bindingResult.hasErrors()) {
			return "formConsultation";
		}
        
		
		Principal principal = request.getUserPrincipal();
        List <Medcin> medcins = medcinRepository.chercher(principal.getName());
		
        consultation.setMedecin(medcins.get(0));
		
        Optional<Patient> p = patientRepository.findById(id);
        
        if(p.isPresent()) {
        	Patient patient = p.get();
        	consultation.setPatient(patient);
        }
		
		
		consultationRepository.save(consultation);

		return "redirect:/medcin/patients";
	}
	
	
	
}
