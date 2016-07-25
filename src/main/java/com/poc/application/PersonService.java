package com.poc.application;

import java.util.List;

import com.poc.model.Person;

public interface PersonService {

	Person findPerson(String id);
	
	List<Person> findAllPerson();
}
