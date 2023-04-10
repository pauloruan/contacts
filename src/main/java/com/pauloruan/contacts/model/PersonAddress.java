package com.pauloruan.contacts.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "person_address")
public class PersonAddress {
    @EmbeddedId
    private PersonAddressKey id;

    @Column
    private Boolean isPrimary;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Person.class)
    @MapsId("personId")
    @JoinColumn(name = "person_id", unique = true, nullable = false)
    private Person persons;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Address.class)
    @MapsId("addressId")
    @JoinColumn(name = "address_id", unique = true, nullable = false)
    private Address addresses;
}
