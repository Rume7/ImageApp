package com.codehacks.service;

import com.codehacks.entities.Media;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface ImageService2 {

    Media uploadImageForCustomer(UUID customerId, MultipartFile image);
}
