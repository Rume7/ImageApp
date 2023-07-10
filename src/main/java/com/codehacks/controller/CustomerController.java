package com.codehacks.controller;

import com.codehacks.entities.Customer;
import com.codehacks.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerService customerService;

    @PostMapping("/")
    ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.createCustomer(customer);
        if (newCustomer == null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") Integer customerId,
                            @RequestBody Customer customer) {
        Customer cust = customerService.updateCustomer(customerId, customer);
        return new ResponseEntity<>(cust, HttpStatus.OK);
    }
}
