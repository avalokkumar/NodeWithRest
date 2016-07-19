package com.poc.application;

import java.util.List;

import com.poc.model.Person;

public interface PersonService {

	Person findPerson(long id);
	
	List<Person> findAllPerson();
}
