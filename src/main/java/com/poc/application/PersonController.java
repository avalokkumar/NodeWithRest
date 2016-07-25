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
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET, headers = { "Accept=application/xml" }, produces="application/xml")
	public Person getPerson(@PathVariable(value="id") String id) {
		System.out.println("Id : "+id);
		return personService.findPerson(id);
	}
	
	@RequestMapping(path="/allPerson", method=RequestMethod.GET, headers = { "Accept=application/xml" }, produces="application/xml")
	public List<Person> getAllPerson(){
		System.out.println("To retrieve all person details");
		return personService.findAllPerson();
	}
	
	/*@RequestMapping(path="/personInt", method=RequestMethod.POST, produces="application/octect-stream")
	public Response getPersonInterview(){
		File file = new File("../media/TomAndJerry.mpg");
		System.out.println("To retrieve all person details");
		return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
			      .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"" )
			      .build();
	}*/

	public PersonService getPersonService() {
		return personService;
	}
	
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
}

