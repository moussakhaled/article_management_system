package tn.moussa.springbootangular.ams.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.moussa.springbootangular.ams.entities.Person;
import tn.moussa.springbootangular.ams.form.PersonForm;

@Controller
public class PersonController {
	private static List<Person> persons = new ArrayList<Person>();
	
	static {
		persons.add(new Person("Albert", "EINSTEIN"));
		persons.add(new Person("Frederic", "GAUSS"));
	}
	
	//Injection via application.properties
	@Value("${welcome.message}")
	private String message;
	
	@Value("${error.message}")
	private String errorMessage;
	
	@GetMapping(value = {"/index"})//, "/Person"})
	public String index(Model model) {
			model.addAttribute("message", message);
			return "pages/person/index";
	}
	
	@GetMapping(value = {"/personList"})
	public String personList(Model model) {
			model.addAttribute("persons", persons);
			return "pages/person/personList";
	}
	
	@GetMapping(value = {"/addPerson"})
	public String showAddPersonPage(Model model) {
			PersonForm personForm = new PersonForm();
			model.addAttribute("personForm", personForm);
			return "pages/person/addPerson";
	}
	
	@PostMapping(value = {"/addPerson"})
	public String savePerson(Model model, @ModelAttribute("personForm") PersonForm personForm) {
			String firstName  = personForm.getFirstName();
			String lastName  = personForm.getLastName();
			
			if(firstName != null && firstName.length() > 0 && lastName != null && lastName.length() > 0 ) {
				Person newPerson = new Person(firstName, lastName);
				persons.add(newPerson);
				
				return "redirect:/personList";
			}
			
			
			model.addAttribute("errorMessage", errorMessage);
			return "pages/person/addPerson";
	}
	

}
