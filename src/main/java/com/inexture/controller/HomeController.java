package com.inexture.controller;

import com.inexture.dto.CustomerDto;
import com.inexture.model.Customer;
import com.inexture.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@Slf4j
public class HomeController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody Customer customer)
    {
        try {
            log.info("save user" + customer);
            return new ResponseEntity<>(customerService.save(customer), HttpStatus.OK);
        }
        catch (Exception e)
        {
            log.error("user not save");
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/saveAllCustomer")
    public ResponseEntity<?> saveUser(@RequestBody List<Customer> customer)
    {
        try {
            log.info("save all user");
            return new ResponseEntity<>(customerService.saveAllCustomer(customer), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable int id)
    {
        try{
            log.info("user found "+id);
            return new ResponseEntity<>(customerService.findById(id),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllCustomer()
    {
        try{
            return new ResponseEntity<>(customerService.getAllCustomer(),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable int id)
    {
        try{
            customerService.deleteCustomer(id);
            return new ResponseEntity<>("delete successfully",HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/name")
    public ResponseEntity<?> findByFirstName(@RequestBody CustomerDto customerDto)
    {
        try{
            return new ResponseEntity<>(customerService.findByFirstName(customerDto.getFirstName(),customerDto.getLastName()),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/city/{city}")
    public ResponseEntity<?> findByCity(@PathVariable String city)
    {
        try {
            log.info("user find by city: "+city);
            return new ResponseEntity<>(customerService.findByCity(city),HttpStatus.OK);
        }
        catch (Exception e)
        {
            log.info("user not found");
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/any-city/{city}")
    public ResponseEntity<?> findAnyThings(@PathVariable String city)
    {
        try {
            log.info("user find");
            return new ResponseEntity<>(customerService.findByAnything(city),HttpStatus.OK);
        }
        catch (Exception e)
        {
            log.info("user not found there is an exception");
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/any-thing/{firstName}")
    public ResponseEntity<?> findByRegex(@PathVariable String firstName)
    {
        try {
            log.info("user find");
            return new ResponseEntity<>(customerService.findByRegex(firstName),HttpStatus.OK);
        }
        catch (Exception e)
        {
            log.info("user not found there is an exception");
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
