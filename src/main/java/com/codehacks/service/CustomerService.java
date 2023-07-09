package com.codehacks.service;

import com.codehacks.dto.CustomerDTO;
import com.codehacks.dto.CustomerDTOMapper;
import com.codehacks.entities.Customer;
import com.codehacks.exception.ResourceNotFoundException;
import com.codehacks.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDTOMapper customerDTOMapper;

    @Override
    public Customer createCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(UUID.randomUUID());
        customer.setName(customerDTO.name());
        customer.setMedia(customerDTO.mediaSet());

        customerRepository.save(customer);
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(UUID customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Customer updateCustomer(UUID customerId, CustomerDTO cust) {
        var customer = findOrThrow(customerId);
        if (cust.name() != null) {
            customer.setName(cust.name());
        }
        if (cust.mediaSet() != null) {
            customer.setMedia(cust.mediaSet());
        }
        return customerRepository.save(customer);
    }

    private Customer findOrThrow(final UUID id) {
        return customerRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
