package com.codehacks.service;

import com.codehacks.dto.CustomerDTO;
import com.codehacks.dto.CustomerDTOMapper;
import com.codehacks.entities.Customer;import com.codehacks.entities.Media;
import com.codehacks.exception.ResourceNotFoundException;
import com.codehacks.repositories.CustomerRepository;
import com.codehacks.repositories.MediaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;
    private final MediaRepository mediaRepository;
    private final CustomerDTOMapper customerDTOMapper;

    @Override
    public Customer createCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.name());
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
    public Customer updateCustomer(Integer customerId, CustomerDTO cust) {
        var customer = findOrThrow(customerId);
        if (cust.name() != null) {
            customer.setName(cust.name());
        }
        return customerRepository.save(customer);
    }

    private Customer findOrThrow(final Integer id) {
        return customerRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
