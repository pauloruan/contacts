package com.pauloruan.contacts.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class PersonAddressKey implements Serializable {

    @Column
    private Long personId;

    @Column
    private Long addressId;
}
