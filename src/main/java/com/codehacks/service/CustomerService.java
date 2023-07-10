package com.codehacks.service;

import com.codehacks.entities.Customer;
import com.codehacks.exception.ResourceNotFoundException;
import com.codehacks.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        Customer cust = new Customer();
        cust.setName(customer.getName());
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        return findOrThrow(customerId);
    }

    @Override
    public Customer updateCustomer(Integer customerId, Customer cust) {
        var customer = findOrThrow(customerId);
        if (cust.getName() != null) {
            customer.setName(cust.getName());
        }
        return customerRepository.save(customer);
    }

    private Customer findOrThrow(final Integer id) {
        return customerRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
