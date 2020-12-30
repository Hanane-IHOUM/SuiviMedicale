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

import com.proj.dao.MedcinRepository;
import com.proj.entities.Medcin;



@Controller
public class MedcinContoller {
	
	@Autowired
	private MedcinRepository medcinRepository;
	
	
	//@Autowired
	//private BCryptPasswordEncoder bCryptPasswordEncoder;

	
	@RequestMapping(value="/admin/medcins")
	public String indexMedcin(Model model , @RequestParam(name="mc", defaultValue="")String mc) {
		
		List <Medcin> medcins = medcinRepository.chercher("%"+mc+"%");
		model.addAttribute("listMedcins", medcins);
		model.addAttribute("mc", mc);
		return "medcins";
	}
	
	
	
	@RequestMapping(value="/admin/deleteMedcin", method=RequestMethod.GET)
	public String deleteMedcin(Long id, String mc) {
		medcinRepository.deleteById(id);
		return "redirect:/admin/medcins?mc="+mc;
	}
	
	
	@RequestMapping(value="/admin/formMedcin", method=RequestMethod.GET)
	public String formPMedcin(Model model) {
		model.addAttribute("medcin", new Medcin());
		return "formMedcin";
	}
	
	
	@RequestMapping(value="/admin/editMedcin", method=RequestMethod.GET)
	public String editMedcin(Model model, Long id) {
		Optional<Medcin> m = medcinRepository.findById(id);
		
		if(m.isPresent()) {
			  Medcin medcin = m.get();
			  model.addAttribute("medcin", medcin);
		}
		
		return "editMedcin";
	}
	
	@RequestMapping(value="/admin/saveMedcin", method=RequestMethod.POST)
	public String saveMedcin(Model model, @Valid Medcin medcin, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "formMedcin";
		}
		
		//String encodedPassword = bCryptPasswordEncoder.encode(medcin.getPassword());

		
		medcinRepository.save(medcin);
		return "confirmationMedcin";
	}
	

}
