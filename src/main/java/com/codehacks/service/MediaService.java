package com.codehacks.service;

import com.codehacks.dto.MediaDTO;
import com.codehacks.dto.TagDTO;
import com.codehacks.entities.Media;
import com.codehacks.entities.Person;
import com.codehacks.entities.Tag;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface MediaService {

    MediaDTO uploadImageForCustomer(Integer customerId, MultipartFile image)
            throws IOException;

    Set<TagDTO> tagAnImage(List<Person> names, Integer media);
}
