package br.edu.univs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univs.data.model.Person;
import br.edu.univs.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public Person create(Person person) {
		var entity = personRepository.save(person);

		return entity;
	}

	public Person findById(String id) {
		Person entity = personRepository.findById(Long.parseLong(id)).orElse(null);

		return entity;
	}

	public void delete(Long id) {
		var entity = personRepository.findById(id).orElse(null);

		personRepository.delete(entity);
	}

	public List<Person> findAll() {
		return personRepository.findAll();
	}

}
