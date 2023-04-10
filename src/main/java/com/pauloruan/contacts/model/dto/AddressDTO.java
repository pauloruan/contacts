package com.pauloruan.contacts.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private Long id;
    private Boolean isPrimary;
    private String street;
    private String number;
    private String city;
    private String zipCode;
}
