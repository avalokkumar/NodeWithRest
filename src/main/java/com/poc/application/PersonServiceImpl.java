package com.poc.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.poc.model.Address;
import com.poc.model.Contact;
import com.poc.model.Person;

@Service
public class PersonServiceImpl implements PersonService{
	
	private List<Person> persons;

	public PersonServiceImpl() {
		//AtomicLong idGen = new AtomicLong();
		persons = new ArrayList<>();
		Person person1 = new Person();
		Address address1 = new Address("Addr1", "Addr2", "Ranchi", "Jh", "835222");
		Contact contact1 = new Contact("9824984343","8646384393", "512435623");
		person1 = new Person(11, "Clayman", 25, address1,contact1);
		persons.add(person1);
		Person person2 = new Person();
		Address address2 = new Address("Address1", "Address2", "Raipur", "Chattisgarh", "542444");
		Contact contact2 = new Contact("8872438234","772674333", "10320202");
		person2 = new Person(22, "Camper", 27, address2, contact2);
		persons.add(person2);
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	public List<Person> getPersons() {
		return persons;
	}
	/*	private Person createPerson(long personId, String name, int age, Address address, Contact contact) {
			return new Person(personId, name, age, address, contact);
	}*/
	
	public Person findPerson(String id){
		
		for (Person person : persons) {
			if(String.valueOf(person.getPersonId()).equals(id)){
				return person;
			}
		}
		return new Person();
		/*return persons.stream()				   // Convert to steam
				.filter(x -> id.equals(x.getPersonId()))
				.findAny()				// If 'findAny' then return found
				.orElse(null);*/
	}
	
	public List<Person> findAllPerson(){
		return persons;
	}
}
