package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Address;

import java.util.List;

public interface AddressService {
    Address save(Address address);
    Address update(Long id, Address address);
    Address find(Long id);
    List<Address> findAll();
    Address delete(Long id);
}
