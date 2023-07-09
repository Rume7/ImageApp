package com.codehacks.service;

import com.codehacks.entities.Media;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

public interface MediaService {

    Media uploadImageForCustomer(UUID customerId, MultipartFile image)
            throws IOException;
}
