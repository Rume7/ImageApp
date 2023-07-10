package com.codehacks.service;

import com.codehacks.entities.Customer;
import com.codehacks.entities.Media;
import com.codehacks.exception.ResourceNotFoundException;
import com.codehacks.repositories.CustomerRepository;
import com.codehacks.repositories.MediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MediaServiceImpl implements MediaService {

    @Autowired
    private final MediaRepository mediaRepository;

    @Autowired
    private final CustomerRepository customerRepository;

    public Media uploadImageForCustomer(UUID customerId, MultipartFile image) throws IOException {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            return uploadImage(image, customer.get());
        }
        throw new ResourceNotFoundException();
    }

    private Media uploadImage(MultipartFile image, Customer customer) throws IOException {
        Media media = new Media();
        media.setId(generateKey());
        media.setType(image.getContentType());
        media.setDate(LocalDateTime.now());
        media.setImage(image.getBytes());
        media.setCustomer(customer);

        mediaRepository.save(media);
        return media;
    }

    private UUID generateKey() {
        return UUID.randomUUID();
    }
}
