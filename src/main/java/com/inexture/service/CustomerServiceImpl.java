package com.inexture.service;

import com.inexture.model.Customer;
import com.inexture.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Customer save(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Iterable<Customer> saveAllCustomer(List<Customer> customers) {
        return customerRepo.saveAll(customers);
    }

    @Override
    public Optional<Customer> findById(int id) {
        return customerRepo.findById(id);
    }

    @Override
    public Iterable<Customer> getAllCustomer() {
        return customerRepo.findAll();
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepo.deleteById(id);
    }
}
