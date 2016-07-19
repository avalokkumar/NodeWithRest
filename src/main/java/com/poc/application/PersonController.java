package com.poc.application;

import java.util.List;

import javax.ws.rs.PathParam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poc.model.Person;
	

@RestController
@RequestMapping("/person")
public class PersonController {

//	@Autowired(required=true)
	//public PersonService personService = new PersonServiceImpl();

	@RequestMapping(path="/{id}", method=RequestMethod.GET, headers = { "Accept=application/xml" }, produces="application/xml")
	public Person getPerson(@PathParam(value="id") long id) {
		return new Person();
	}
	
	@RequestMapping(path="/", method=RequestMethod.GET, headers = { "Accept=application/xml" }, produces="application/xml")
	public List<Person> getAllPerson(){
		return null;
		//return personService.findAllPerson();
	}
}

