package com.workintech.s18d4.service;

import com.workintech.s18d4.repository.AddressRepository;
import com.workintech.s18d4.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Long id, Address address) {
        Address existing = find(id);
        address.setId(existing.getId());
        return addressRepository.save(address);
    }

    @Override
    public Address find(Long id) {
        return addressRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address delete(Long id) {
        Address toDelete = find(id);
        addressRepository.delete(toDelete);
        return toDelete;
    }
}
