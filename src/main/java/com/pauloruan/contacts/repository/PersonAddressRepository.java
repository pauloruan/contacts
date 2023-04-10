package com.pauloruan.contacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pauloruan.contacts.model.PersonAddress;
import com.pauloruan.contacts.model.PersonAddressKey;

public interface PersonAddressRepository extends JpaRepository<PersonAddress, PersonAddressKey> {

}
