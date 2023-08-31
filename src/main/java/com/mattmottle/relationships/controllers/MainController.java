package com.mattmottle.relationships.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mattmottle.relationships.models.License;
import com.mattmottle.relationships.models.Person;
import com.mattmottle.relationships.services.LicenseService;
import com.mattmottle.relationships.services.PersonService;


import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	PersonService personService;
	@Autowired 
	LicenseService licenseService;
	
	@GetMapping("/")
	public String home(Model model) {
	     model.addAttribute("persons", personService.readAllPersons());
		return "index.jsp";
	}
	@GetMapping("/persons/new")
	public String newPerson(@ModelAttribute Person person) {
		return "newPerson.jsp";
	}
			
	@PostMapping("persons/new/process")
	public String createNewPerson(Model model, @Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) { 
			return "newPerson.jsp"; 
		} 
		else {
			personService.createPerson(person);
			return "redirect:/";
		}
	}
	@GetMapping("/licenses/new")
	public String newLicense(Model model, @ModelAttribute License license) {
		List<Person> persons = personService.readAllPersons();
		model.addAttribute("persons", persons);
		return "newLicense.jsp";
	}
			
	@PostMapping("licenses/new/process")
	public String createNewLicense(Model model, @Valid @ModelAttribute("license") License license, BindingResult result) {
		if (result.hasErrors()) { 
			return "newLicense.jsp"; 
		} 
		else {
			licenseService.createLicense(license);
			return "redirect:/";
		}
	}
	
	@GetMapping("/{personId}")
	public String index(Model model, @PathVariable("personId") Long personId) {
		Person person = personService.findPerson(personId);
		model.addAttribute("person", person);
		return "person.jsp";
	}
}