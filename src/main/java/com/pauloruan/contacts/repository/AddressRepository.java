package com.pauloruan.contacts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pauloruan.contacts.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query("SELECT ad FROM Address ad JOIN ad.personAddress pa WHERE pa.id.personId = ?1")
    List<Address> findByPersonId(long personId);

    @Query("SELECT ad FROM Address ad JOIN ad.personAddress pa WHERE pa.id.personId = ?1 AND pa.isPrimary = ?2")
    List<Address> findByPersonIdAndIsPrimary(long personId, boolean isPrimary);
}
