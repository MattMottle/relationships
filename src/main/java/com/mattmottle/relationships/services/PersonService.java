package com.mattmottle.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mattmottle.relationships.models.Person;
import com.mattmottle.relationships.repositories.PersonRepository;
@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	// Create a person
	public Person createPerson(Person newPerson) {
		return personRepository.save(newPerson);
	}
	
	// Read all person
	public List<Person> readAllPersons() {
		return personRepository.findAll();
	}
	// Read one person
	public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }
	//update person
	public Person updatePerson(Person updatedPerson) {
		return personRepository.save(updatedPerson);
}
//	  deletes person
    public void deletePerson(Long id) {
		personRepository.deleteById(id);	
	}
}
