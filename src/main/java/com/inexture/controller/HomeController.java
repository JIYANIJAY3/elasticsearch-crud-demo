package com.inexture.controller;

import com.inexture.model.Customer;
import com.inexture.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class HomeController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody Customer customer)
    {
        try {
            return new ResponseEntity<>(customerService.save(customer), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/saveAllCustomer")
    public ResponseEntity<?> saveUser(@RequestBody List<Customer> customer)
    {
        try {
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

    @GetMapping(value = "/{city}")
    public void findByCity(@PathVariable String city)
    {
        System.out.println(city);
       // return "null";
    }

}
