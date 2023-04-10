package com.pauloruan.contacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pauloruan.contacts.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
