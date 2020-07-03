package com.wildadventures.msusers.consumer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wildadventures.msusers.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
