package com.workintech.s18d4.repository;

import com.workintech.s18d4.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    default Optional<Customer> findById(int id) {
        return findById(Long.valueOf(id));
    }
}
