package com.codehacks.controller;

import com.codehacks.dto.CustomerDTO;
import com.codehacks.entities.Customer;
import com.codehacks.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerService customerService;

    @PostMapping("/")
    Customer createCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.createCustomer(customerDTO);
    }

    @PutMapping("/{customerId}")
    Customer updateCustomer(@PathVariable("customerId") UUID customerId,
                            @RequestBody CustomerDTO customer) {
        return customerService.updateCustomer(customerId, customer);
    }
}
