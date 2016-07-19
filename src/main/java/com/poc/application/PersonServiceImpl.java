package com.poc.application;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.poc.model.Address;
import com.poc.model.Contact;
import com.poc.model.Person;

public class PersonServiceImpl implements PersonService{
	
	private List<Person> persons;
	
	{
		AtomicLong idGen = new AtomicLong();
		Person person1 = createPerson(idGen.incrementAndGet(), "Clayman", 25, 
				createAddress("Addr1", "Addr2", "Ranchi", "Jh", "835222"),
				createContact("9824984343","8646384393", "512435623"));
		persons.add(person1);
		Person person2 = createPerson(idGen.incrementAndGet(), "Camper", 27, 
				createAddress("Address1", "Address2", "Raipur", "Chattisgarh", "542444"),
				createContact("8872438234","772674333", "10320202"));
		persons.add(person2);
	}
	
	private Person createPerson(long personId, String name, int age, Address address, Contact contact) {
		return new Person(personId, name, age, address, contact);
	}

	private Contact createContact(String phone1, String phone2, String fax) {
		return new Contact(phone1, phone2, fax);
	}
	
	private Address createAddress(String add1, String add2, String city, String state, String pin) {
		return new Address(add1, add2, city, state, pin);
	}
	
	public Person findPerson(long id){
		return persons.stream()				   // Convert to steam
				.filter(x -> String.valueOf(id).equals(x.getPersonId()))
				.findAny()				// If 'findAny' then return found
				.orElse(null);
	}
	
	public List<Person> findAllPerson(){
		return persons;
	}
}
