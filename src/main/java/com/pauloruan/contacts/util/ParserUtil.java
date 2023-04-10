package com.pauloruan.contacts.util;

import com.pauloruan.contacts.model.Address;
import com.pauloruan.contacts.model.Person;
import com.pauloruan.contacts.model.PersonAddress;
import com.pauloruan.contacts.model.dto.AddressDTO;
import com.pauloruan.contacts.model.dto.PersonDTO;

public class ParserUtil {
    public static Person toModel(PersonDTO personDTO) {
        Person person = new Person();
        person.setPersonId(personDTO.getId());
        person.setName(personDTO.getName());
        person.setBirthDate(personDTO.getBirthDate());
        return person;
    }

    public static PersonDTO toDTO(Person person) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(person.getPersonId());
        personDTO.setName(person.getName());
        personDTO.setBirthDate(person.getBirthDate());
        return personDTO;
    }

    public static Address toModel(AddressDTO addressDTO) {
        Address address = new Address();

        address.setAddressId(addressDTO.getId());
        address.setStreet(addressDTO.getStreet());
        address.setZipCode(addressDTO.getZipCode());
        address.setNumber(addressDTO.getNumber());
        address.setCity(addressDTO.getCity());
        return address;
    }

    public static AddressDTO toDTO(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(address.getAddressId());
        addressDTO.setCity(address.getCity());
        addressDTO.setNumber(address.getNumber());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setZipCode(address.getZipCode());
        PersonAddress personAddress = address.getPersonAddress().get(0);
        addressDTO.setIsPrimary(personAddress.getIsPrimary());
        return addressDTO;

    }

}
