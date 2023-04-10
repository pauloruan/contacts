package com.pauloruan.contacts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauloruan.contacts.model.Person;
import com.pauloruan.contacts.model.dto.PersonDTO;
import com.pauloruan.contacts.repository.PersonRepository;
import com.pauloruan.contacts.util.ParserUtil;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<PersonDTO> listAllPersons() {
        return personRepository.findAll()
                .stream()
                .map(ParserUtil::toDTO)
                .toList();
    }

    public PersonDTO findPersonById(Long id) {
        return personRepository.findById(id)
                .map(ParserUtil::toDTO)
                .orElseThrow(() -> new RuntimeException("Person not found"));
    }

    public PersonDTO createPerson(PersonDTO personDTO) {
        Person person = ParserUtil.toModel(personDTO);
        person.setPersonId(null);
        person = this.personRepository.save(person);
        return ParserUtil.toDTO(person);
    }

    public PersonDTO updatePerson(PersonDTO personDTO) {
        Person person = ParserUtil.toModel(personDTO);
        person = personRepository.save(person);
        return ParserUtil.toDTO(person);
    }
}
