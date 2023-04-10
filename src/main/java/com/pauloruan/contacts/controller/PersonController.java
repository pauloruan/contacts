package com.pauloruan.contacts.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pauloruan.contacts.model.dto.PersonDTO;
import com.pauloruan.contacts.service.PersonService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/person")
@AllArgsConstructor
public class PersonController {

    private PersonService personService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDTO> listAllPersons() {
        return personService.listAllPersons();
    }

    @GetMapping("/{personId}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO findPersonById(@PathVariable(value = "personId") Long personId) {
        return personService.findPersonById(personId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDTO createPerson(@RequestBody PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO updatePerson(@RequestBody PersonDTO personDTO) {
        return personService.updatePerson(personDTO);
    }
}
