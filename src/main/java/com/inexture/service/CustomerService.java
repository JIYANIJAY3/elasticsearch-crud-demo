package com.inexture.service;

import com.inexture.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer save(Customer customer);

    Iterable<Customer> saveAllCustomer(List<Customer> customers);

    Optional<Customer> findById(int id);

    Iterable<Customer> getAllCustomer();

    void deleteCustomer(int id);

    List<Customer> findByCity(String city);

    List<Customer> findByFirstName(String firstName,String lastName);
}
