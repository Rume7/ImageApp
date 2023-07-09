package com.codehacks.service;

import com.codehacks.entities.Customer;
import com.codehacks.entities.Media;
import com.codehacks.repositories.CustomerRepository;
import com.codehacks.repositories.MediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageService2Impl implements ImageService2 {

    @Autowired
    private final MediaRepository mediaRepository;

    @Autowired
    private final CustomerRepository customerRepository;

    public Media uploadImageForCustomer(UUID customerId, MultipartFile image) {
        Customer customer = customerRepository.getCustomerById(customerId);
        return uploadImage(image, customer);
    }

    private Media uploadImage(MultipartFile image, Customer customer) {
        Media media = new Media();
        media.setId(generateKey());
        media.setType(image.getContentType());
        media.setDate(LocalDateTime.now());
        media.setCustomer(customer);

        mediaRepository.save(media);
        return media;
    }

    private UUID generateKey() {
        return UUID.randomUUID();
    }
}
