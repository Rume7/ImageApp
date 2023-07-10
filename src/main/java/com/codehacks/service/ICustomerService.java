package com.codehacks.service;

import com.codehacks.entities.Customer;

import java.util.List;

public interface ICustomerService {

    Customer createCustomer(Customer customer);

    Customer getCustomerById(Integer customerId);

    List<Customer> getAllCustomers();

    Customer updateCustomer(Integer customerId, Customer customer);
}
