package com.codehacks.service;

import com.codehacks.dto.CustomerDTO;
import com.codehacks.dto.CustomerDTOMapper;
import com.codehacks.entities.Customer;
import com.codehacks.entities.Media;
import com.codehacks.exception.ResourceNotFoundException;
import com.codehacks.repositories.CustomerRepository;
import com.codehacks.repositories.MediaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;
    private final MediaRepository mediaRepository;
    private final CustomerDTOMapper customerDTOMapper;

    @Override
    public Customer createCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(UUID.randomUUID());
        customer.setName(customerDTO.name());
        customer.setMedia(customerDTO.mediaSet());

        if (customerDTO.mediaSet() != null) {
            for (Media media : customerDTO.mediaSet()) {
                Media newMedia = new Media();
                newMedia.setType(media.getType());
                newMedia.setDate(LocalDateTime.now());
                newMedia.setImage(media.getImage());
                newMedia.setTags(media.getTags());
                newMedia.setCustomer(media.getCustomer());

                mediaRepository.save(newMedia);
            }
        }
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(UUID customerId) {
        return findOrThrow(customerId);
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
