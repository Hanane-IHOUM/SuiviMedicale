package com.proj.web;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.proj.dao.PatientRepository;
import com.proj.entities.Patient;

@Controller
public class PatientContoller {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@RequestMapping(value="/admin/patients")
	public String index(Model model , @RequestParam(name="mc", defaultValue="")String mc) {
		
		List <Patient> patients = patientRepository.chercher("%"+mc+"%");
		model.addAttribute("listPatients", patients);
		model.addAttribute("mc", mc);
		return "patients";
	}
	
	@RequestMapping(value="/medcin/patients")
	public String indexMed(Model model , @RequestParam(name="mc", defaultValue="")String mc) {
		
		List <Patient> patients = patientRepository.chercher("%"+mc+"%");
		model.addAttribute("listPatients", patients);
		model.addAttribute("mc", mc);
		return "ListPatients";
	}
	
	
	
	@RequestMapping(value="/admin/delete", method=RequestMethod.GET)
	public String delete(Long id, String mc) {
		patientRepository.deleteById(id);
		return "redirect:/admin/patients?mc="+mc;
	}
	
	
	@RequestMapping(value="/admin/form", method=RequestMethod.GET)
	public String formPatient(Model model) {
		model.addAttribute("patient", new Patient());
		return "formPatient";
	}
	
	
	@RequestMapping(value="/admin/edit", method=RequestMethod.GET)
	public String edit(Model model, Long id) {
		Optional<Patient> p = patientRepository.findById(id);
		
		if(p.isPresent()) {
			  Patient patient = p.get();
			  model.addAttribute("patient", patient);
		}
		
		return "editPatient";
	}
	
	@RequestMapping(value="/admin/save", method=RequestMethod.POST)
	public String save(Model model, @Valid Patient patient, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "formPatient";
		}
		patientRepository.save(patient);
		return "confirmation";
	}
	
	
	
	@RequestMapping(value="/")
	public String home(HttpServletRequest request) {
		boolean isAdmin = request.isUserInRole("ADMIN");
		if(isAdmin) {
			return "redirect:/admin/patients";
		}
		return "redirect:/medcin/patients";

		//return "hello";
		
		//return "redirect:/medcin/patients";
	}
	
	
	@RequestMapping(value="/403")
	public String accessDneied() {
		return "403";
	}
	
	

}
