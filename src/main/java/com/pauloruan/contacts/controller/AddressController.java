package com.pauloruan.contacts.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pauloruan.contacts.model.dto.AddressDTO;
import com.pauloruan.contacts.service.AddressService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/person/{personId}/address")
@AllArgsConstructor
public class AddressController {

    private AddressService addressService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AddressDTO> findAllAddressesByPersonId(@PathVariable Long personId) {
        return addressService.findAllAddressesByPersonId(personId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressDTO createAddress(@PathVariable Long personId, AddressDTO addressDTO) {
        return addressService.createAddress(personId, addressDTO);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public AddressDTO updateAddress(AddressDTO addressDTO) {
        return addressService.updateAddress(addressDTO);
    }

    @GetMapping("/primary")
    @ResponseStatus(HttpStatus.OK)
    public List<AddressDTO> findPrimaryAddress(@PathVariable Long personId) {
        return addressService.findPrimaryAddress(personId);
    }
}
