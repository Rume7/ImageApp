package com.codehacks.service;

import com.codehacks.dto.CustomerDTO;
import com.codehacks.entities.Customer;

import java.util.List;
import java.util.UUID;

public interface ICustomerService {

    Customer createCustomer(CustomerDTO customer);

    Customer getCustomerById(Integer customerId);

    List<Customer> getAllCustomers();

    Customer updateCustomer(Integer customerId, CustomerDTO customer);
}
