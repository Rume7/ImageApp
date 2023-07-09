package com.codehacks.service;

import com.codehacks.dto.CustomerDTO;
import com.codehacks.entities.Customer;

import java.util.List;
import java.util.UUID;

public interface ICustomerService {

    Customer createCustomer(CustomerDTO customer);

    Customer getCustomerById(UUID customerId);

    List<Customer> getAllCustomers();

    CustomerDTO updateCustomer(UUID customerId, Customer customerRequest);
}
