package com.codehacks.service;

import com.codehacks.entities.Customer;
import com.codehacks.entities.Media;
import com.codehacks.entities.Person;
import com.codehacks.entities.Tag;
import com.codehacks.exception.ResourceNotFoundException;
import com.codehacks.repositories.CustomerRepository;
import com.codehacks.repositories.MediaRepository;
import com.codehacks.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MediaServiceImpl implements MediaService {

    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    private final MediaRepository mediaRepository;
    @Autowired
    private final TagRepository tagRepository;

    public Media uploadImageForCustomer(Integer customerId, MultipartFile image) throws IOException {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            return uploadImage(image, customer.get());
        }
        throw new ResourceNotFoundException();
    }

    private Media uploadImage(MultipartFile image, Customer customer) throws IOException {
        Media media = new Media();
        media.setType(image.getContentType());
        media.setDate(LocalDateTime.now());
        media.setImage(image.getBytes());
        media.setCustomer(customer);
        return mediaRepository.saveAndFlush(media);
    }

    public Set<Tag> tagAnImage(List<Person> names, Integer mediaId) {
        Optional<Media> media = mediaRepository.findById(mediaId);
        if (media.isPresent()) {
            Set<Tag> allTags = new HashSet<>();
            for (Person person : names) {
                Tag aTag = new Tag();
                aTag.setName(person.toString());
                aTag.setMedia(media.get());
                allTags.add(aTag);
                tagRepository.saveAndFlush(aTag);
            }
            return allTags;
        }
        throw new ResourceNotFoundException();
    }
}
