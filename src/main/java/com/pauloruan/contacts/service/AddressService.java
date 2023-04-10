package com.pauloruan.contacts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauloruan.contacts.model.Address;
import com.pauloruan.contacts.model.PersonAddress;
import com.pauloruan.contacts.model.PersonAddressKey;
import com.pauloruan.contacts.model.dto.AddressDTO;
import com.pauloruan.contacts.repository.AddressRepository;
import com.pauloruan.contacts.repository.PersonAddressRepository;
import com.pauloruan.contacts.util.ParserUtil;


@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PersonAddressRepository personAddressRepository;

    public List<AddressDTO> findAllAddressesByPersonId(Long personId) {
        List<Address> listAddress = addressRepository.findByPersonId(personId);
        if (listAddress != null && !listAddress.isEmpty()) {
            return listAddress.stream().map(ParserUtil::toDTO).toList();
        }
        throw new RuntimeException("Addresses not found.");
    }

    public AddressDTO updateAddress(AddressDTO addressDTO) {
        Address address = ParserUtil.toModel(addressDTO);
        address = addressRepository.save(address);
        return ParserUtil.toDTO(address);
    }

    public AddressDTO createAddress(Long personId, AddressDTO addressDTO) {
        Address address = ParserUtil.toModel(addressDTO);
        address = addressRepository.save(address);

        PersonAddressKey personAddressKey = new PersonAddressKey();
        personAddressKey.setPersonId(personId);
        personAddressKey.setAddressId(address.getAddressId());

        PersonAddress personAddress = new PersonAddress();
        personAddress.setId(personAddressKey);
        personAddress.setIsPrimary(Boolean.FALSE);

        personAddressRepository.save(personAddress);
        return ParserUtil.toDTO(address);
    }

    public List<AddressDTO> findPrimaryAddress(Long personId) {
        List<Address> listAddress = addressRepository.findByPersonIdAndIsPrimary(personId, true);
        if (listAddress != null && !listAddress.isEmpty()) {
            return listAddress.stream().map(ParserUtil::toDTO).toList();
        }
        throw new RuntimeException("Primary address not found.");
    }
}
