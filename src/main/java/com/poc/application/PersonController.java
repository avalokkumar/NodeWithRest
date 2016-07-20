package com.poc.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poc.model.Person;
	

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired(required=true)
	public PersonService personService;
	/*
	public PersonController(PersonService personService){
		this.personService = personService;
	}*/
	
	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
//, headers = { "Accept=application/xml" }
	@RequestMapping(path="/{id}", method=RequestMethod.GET, headers = { "Accept=application/xml" }, produces="application/xml")
	public Person getPerson(@PathVariable(value="id") String id) {
		System.out.println("Id : "+id);
		return personService.findPerson(id);
	}
	
	@RequestMapping(path="/", method=RequestMethod.GET, headers = { "Accept=application/xml" }, produces="application/xml")
	public List<Person> getAllPerson(){
		System.out.println("To retrieve all person details");
		return personService.findAllPerson();
	}

}

